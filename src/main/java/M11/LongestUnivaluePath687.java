package M11;

//687. 最⻓同值路径
public class LongestUnivaluePath687 {
    int ret;

    public int longestUnivaluePath(TreeNode root) {
        ret = 0;
        dfs(root);
        return ret;
    }

    int dfs(TreeNode root) {
        if (root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);

        if (root.left != null && root.left.val == root.val) {
            l += 1;
        } else {
            l = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            r += 1;
        } else {
            r = 0;
        }
        ret = Math.max(l+r,ret);
        return l>r ? l:r;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val =val;}
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


