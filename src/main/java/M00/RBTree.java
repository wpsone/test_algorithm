package M00;

import org.omg.CORBA.PRIVATE_MEMBER;

public class RBTree {
    class Node {
        int val,color;
        Node left,right;
    }

    Node NIL;
    Node root;

    public RBTree() {
        NIL=new Node();
        NIL.val=-1;
        NIL.color=1;
        NIL.left=NIL.right=NIL;
        root=NIL;
    }

    private Node getNewNode(int val) {
        Node p = new Node();
        p.val=val;
        p.color=0;
        p.left=p.right=NIL;
        return p;
    }

    private boolean has_red_child(Node tree) {
        return tree.left.color ==0||tree.right.color==0;
    }

    private Node left_rotate(Node k1) {
        Node k2 = k1.right;
        k1.right=k2.left;
        k2.left=k1;
        return k2;
    }

    private Node right_rotate(Node k2) {
        Node k1 = k2.left;
        k2.left=k1.right;
        k1.right=k2;
        return k1;
    }

    //寻找前驱
    private Node preNode(Node tree) {
        Node p = tree.left;
        while (p.right != null) {
            p=p.right;
        }
        return p;
    }

    public void erase(int val) {
        root = erase(root,val);
    }

    private Node erase(Node tree,int val) {
        tree = __erase(tree,val);
        tree.color=1;
        return tree;
    }

    private Node __erase(Node tree,int val) {
        if (tree==NIL) return tree;
        if (val<tree.val) {
            tree.left = __erase(tree.left,val);
        } else if (val > tree.val) {
            tree.right=__erase(tree.right,val);
        } else {
            if (tree.left == NIL || tree.right == NIL) {
                Node temp = tree.left == NIL ? tree.right:tree.left;
                temp.color += tree.color;
                tree=temp;
                return tree;
            } else {
                Node temp = preNode(tree);
                tree.val = temp.val;
                tree.left = __erase(tree.left,temp.val);
            }
        }
        return erase_maintion(tree);
    }

    private Node erase_maintion(Node tree) {
        if (tree.left.color != 2 && tree.right.color != 2) return tree;
        //兄弟为红，旋转树，新根节点转为⿊，原根节点转为红
        if (has_red_child(tree) ){
            int flag = 0;
            tree.color = 0;
            if (tree.left.color == 0) {
                tree = right_rotate(tree);
                flag=1;
            } else {
                tree=left_rotate(tree);
            }
            tree.color=1;
            if (flag==1) tree.right = erase_maintion(tree.right);
            else tree.left = erase_maintion(tree.left);
            return tree;
        }
        //兄弟为⿊⾊并且没有红⾊⼦节点,⼦节点减⿊，根节点加⿊
        if (tree.left.color == 1 && !has_red_child(tree.left)
                || tree.right.color == 1 && !has_red_child(tree.right)) {
            tree.color += 1;
            tree.left.color-=1;
            tree.right.color-=1;
            return tree;
        }
        // 兄弟节点为⿊并且有红⾊⼦节点
        //      |-- 左⼦树为⿊⾊
        //          |-- 左⼦树的右⼦树为红⾊且左⼦树节点为⿊ LR
        //              |-- ⼦树⼩左旋，新节点转⿊，原节点转红,进⼊LL形态
        //          |-- 左⼦树的左⼦树为红⾊ LL
        //              |-- 整树右旋，新节点改为原根节点的颜⾊，原根节点已经新叔叔节点转为⿊⾊
        //      |-- 右⼦树为⿊⾊
        //          |-- 右⼦树的左⼦树为红⾊且右⼦树节点为⿊ RL
        //              |-- ⼦树⼩右旋，新节点转⿊，原节点转红,进⼊RR形态
        //          |-- 右⼦树的右⼦树为红⾊ RR
        //              |-- 整树左旋，新节点改为原根节点的颜⾊，原根节点已经新叔叔节点转为⿊⾊
        if (tree.left.color == 1) {
            tree.right.color=1;
            if (tree.left.left.color != 0) {
                tree.left.color=0;
                tree.left=left_rotate(tree.left);
                tree.left.color=1;
            }
            tree.left.color=tree.color;
            tree=right_rotate(tree);
        } else {
            tree.left.color=1;
            if (tree.right.right.color != 0) {
                tree.right.color=0;
                tree.right=right_rotate(tree.right);
                tree.right.color=1;
            }
            tree.right.color=tree.color;
            tree=left_rotate(tree);
        }
        tree.left.color=1;
        tree.right.color=1;
        return tree;
    }

    private void insert(int val ) {
        root=insert(root,val);
    }

    private Node insert(Node tree,int val) {
        tree = __insert(tree,val);
        tree.color=1;
        return tree;
    }

    private Node __insert(Node tree,int val) {
        if (tree == NIL) {
            return getNewNode(val);
        }
        if (val < tree.val) {
            tree.left=__insert(tree.left,val);
        } else if (val > tree.val) {
            tree.right=__insert(tree.right,val);
        }
        return insert_maintain(tree);
    }

    private Node insert_maintain(Node tree) {
        if (!has_red_child(tree)) return tree;
        //节点双红
        if (tree.left.color == 0 && tree.right.color == 0) {
            if (!has_red_child(tree.left) && !has_red_child(tree.right)) return tree;
            tree.color=0;
            tree.left.color=tree.right.color=1;
            return tree;
        }
        if (tree.left.color==0 && !has_red_child(tree.left)) return tree;
        if (tree.right.color==0 && !has_red_child(tree.right)) return tree;
        // 左⼦树失衡
        if (tree.left.color == 0) {
            if (tree.left.right.color == 0) {
                tree.left=left_rotate(tree.left);
            }
            tree=right_rotate(tree);
        } else {
            if (tree.right.left.color == 0) {
                tree.right=right_rotate(tree.right);
            }
            tree=left_rotate(tree);
        }
        tree.color=0;
        tree.left.color=tree.right.color=1;
        return tree;
    }

    public void preorder() {
        preorder(root,root.val,0);
    }

    private void preorder(Node tree,int val,int flag) {
        if (tree==NIL) return;
        if (flag == 0) {
            System.out.printf("%d is root, color is %s\n",val,tree.color==0?"red":"black");
        } else {
            System.out.printf("%d is %d's %s child, color is %s\n",
                    tree.val,val,flag==1?"right":"left",tree.color==0?"red":"black");
        }
        preorder(tree.left,tree.val,-1);
        preorder(tree.right,tree.val,1);
    }
}
