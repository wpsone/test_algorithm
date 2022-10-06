package M00;

public class AVL {
    class Node {
        int val;
        int height;
        Node left;
        Node right;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
            height = 0;
        }

        public Node(int val,Node left,Node right) {
            this.val = val;
            this.height = 0;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public AVL() {
        this.root = null;
    }

    public int height() {
        return height(root);
    }

    private int height(Node tree) {
        if (tree!=null) return tree.height;
        return 0;
    }

    private int max(int a,int b) {
        return a>b?a:b;
    }

    //LL 右旋
    private Node leftLeftRotation(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max(height(k2.left),height(k2.right))+1;
        k1.height = max(height(k1.left),height(k1.right))+1;
        return k1;
    }

    //RR 左旋
    private Node rightRightRotation(Node k1) {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max(height(k1.left  ),height(k1.right))+1;
        k2.height = max(height(k2.left),height(k2.right))+1;
        return k2;
    }

    // LR 先局部左旋，然后整体右旋
    private Node leftRightRotation(Node k1) {
        k1.left = rightRightRotation(k1.left);
        return leftLeftRotation(k1);
    }

    // RL 先局部右旋，然后整体左旋
    private Node rightLeftRotation(Node k1) {
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }

    //寻找前驱
    private Node preNode(Node tree) {
        Node p = tree.left;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    //寻找后继
    private Node sucNode(Node tree){
        Node p = tree.right;
        while (p.left != null) {
            p=p.left;
        }
        return p;
    }

    public boolean search(int val) {
        return search(root,val);
    }

    private boolean search(Node tree,int val) {
        if (tree==null) return false;
        if (val<tree.val) return search(tree.left,val);
        if (val>tree.val) return search(tree.right,val);
        return true;
    }

    // 插⼊
    public void insert(int val ) {
        if (search(val)) return;
        root=insert(root,val);
    }

    private Node insert(Node tree,int val) {
        if (tree == null) {
            tree=new Node(val);
        } else if (val < tree.val) {
            tree.left = insert(tree.left,val);
            if (height(tree.left) - height(tree.right) == 2) {
                if (val < tree.left.val) {
                    tree=leftLeftRotation(tree);
                } else {
                    tree = leftRightRotation(tree);
                }
            }
        } else if (val > tree.val) {
            tree.right=insert(tree.right,val);
            if (height(tree.right) - height(tree.left) == 2) {
                if (val < tree.right.val) {
                    tree=rightLeftRotation(tree);
                } else {
                    tree=rightRightRotation(tree);
                }
            }
        }
        tree.height=max(height(tree.left    ),height(tree.right))+1;
        return tree;
    }

    // 删除
    public void remove(int val) {
        if (!search(val)) return;
        root=remove(root,val);
    }

    private Node remove(Node tree,int val) {
        if (tree==null) return null;
        if (val < tree.val) {
            tree.left = remove(tree.left,val);
            if (height(tree.right) - height(tree.left) == 2) {
                Node r = tree.right;
                if (height(r.left) > height(r.right)) {
                    tree=rightLeftRotation(tree);
                } else {
                    tree=rightRightRotation(tree);
                }
            }
        } else if (val > tree.val) {
            tree.right=remove(tree.right,val);
            if (height(tree.left) - height(tree.right) == 2) {
                Node l = tree.left;
                if (height(l.left) > height(l.right)) {
                    tree=leftLeftRotation(tree);
                } else {
                    tree=leftRightRotation(tree);
                }
            }
        } else {
            if (tree.left != null && tree.right != null) {
                if (height(tree.left) > height(tree.right)) {
                    Node pre = preNode(tree);
                    tree.val=pre.val;
                    tree.left=remove(tree.left,pre.val);
                } else {
                    Node suc=sucNode(tree);
                    tree.val=suc.val;
                    tree.right=remove(tree.right,suc.val);
                }
            } else {
                tree=tree.left==null?tree.right:tree.left;
            }
        }
        if (tree!=null) tree.height=max(height(tree.left),height(tree.right))+1;
        return tree;
    }
    // 0:根节点，1：右节点，-1：左节点
    public void preorder() {
        preorder(root,root.val,0);
    }

    private void preorder(Node tree,int val,int flag) {
        if (tree==null) return;
        if (flag == 0) {
            System.out.printf("%d is root\n",val);
        } else {
            System.out.printf("%d is %d's %s child\n",tree.val,val,flag==1?"right":"left");
        }
        preorder(tree.left,tree.val,-1);
        preorder(tree.right,tree.val,1);
    }

    public void inorder() {
        inorder(root);
    }
    private void inorder(Node tree) {
        if (tree==null) return;
        inorder(tree.left);
        System.out.println(tree.val+" ");
        inorder(tree.right);
    }
}
