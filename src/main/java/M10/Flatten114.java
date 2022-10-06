package M10;

//114. ⼆叉树展开为链表
public class Flatten114 {

    TreeNode last;

    public void flatten(TreeNode root) {
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root==null) return;
        preorder(root.right);
        preorder(root.left);
        if (last != null) {
            root.right=last;
            root.left=null;
        }
        last=root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
