import java.util.ArrayList;
import java.util.List;

/**
 * 3. 二叉树实现及遍历
 * 定义：二叉树，是一种特殊的树，二叉树的任意一个节点的度都不大于2，不包含度的节点称之为叶子。
 * 遍历方式：二叉树的遍历方式有三种，中序遍历，先序遍历，后序遍历。
 * 将一个数组中的数以二叉树的存储结构存储，并遍历打印：
 */
public class bintree {
    public bintree left;
    public bintree right;
    public bintree root;
    //数据域
    private Object data;
    //存节点
    public List<bintree> datas;

    public bintree() {

    }

    public bintree(bintree left,bintree right,Object data) {
        this.left=left;
        this.right=right;
        this.data=data;
    }

    //将初始的左右孩子置为空
    public bintree(Object data) {
        this(null,null,data);
    }

    public void create(Object[] objs){
        datas=new ArrayList<bintree>();
        //将一个数组的值依次转换为Node节点
        for (Object o : objs) {
            datas.add(new bintree(o));
        }
        //第一个数为根节点
        root=datas.get(0);
        //建立二叉树
        for (int i = 0; i < objs.length / 2; i++) {
            //左孩子
            datas.get(i).left=datas.get(i*2+1);
            //右孩子
            if (i * 2 + 2 < datas.size()) {//避免偶数的时候下标越界
                datas.get(i).right=datas.get(i*2+2);
            }
        }
    }

    //先序遍历
    public void preorder(bintree root) {
        if (root!=null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    //中序遍历
    public void inorder(bintree root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
    //后序遍历
    public void afterorder(bintree root) {
        if (root != null) {
            afterorder(root.left);
            afterorder(root.right);
            System.out.println(root.data);
        }
    }

    public static void main(String[] args) {
        bintree bintree = new bintree();
        Object []a={2,4,5,7,1,6,12,32,51,22};
        bintree.create(a);
        bintree.afterorder(bintree.root);
    }
}
