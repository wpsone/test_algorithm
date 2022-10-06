package M07;

import M07.Utils.*;

//965. 单值⼆叉树
public class IsUnivalTree965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root==null) return true;
        if (root.left != null && root.val != root.left.val
            ||root.right!=null && root.val != root.right.val) {
            return false;
        }
        if (!isUnivalTree(root.left)||!isUnivalTree(root.right))
            return false;
        return true;
    }
}
