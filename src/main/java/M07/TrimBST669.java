package M07;

import M07.Utils.*;

//669. 修剪⼆叉搜索树
public class TrimBST669 {
    public TreeNode trimBST(TreeNode root,int low,int high){
        if (root==null) return root;
        if (root.val < low) {
            return trimBST(root.right,low,high);
        } else if (root.val > high) {
            return trimBST(root.left,low,high);
        }
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
