package M11;

//623. 在⼆叉树中增加⼀⾏
public class addOneRow623 {
    public TreeNode addOneRow(TreeNode root,int val,int depth) {
        if (root == null) return root;
        if (depth == 1) {
            TreeNode v = new TreeNode(val);
            v.left = root;
            return v;
        } else if (depth - 1 == 1) {
            TreeNode lv = new TreeNode(val);
            TreeNode rv = new TreeNode(val);
            lv.left = root.left;
            rv.right = root.right;
            root.left = lv;
            root.right = rv;
        } else {
            root.left = addOneRow(root.left,val,depth-1);
            root.right = addOneRow(root.right,val,depth-1);
        }
        return root;
    }
}

class TreeNode {
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


