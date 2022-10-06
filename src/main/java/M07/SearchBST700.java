package M07;

import M07.Utils.*;

//700. ⼆叉搜索树中的搜索
public class SearchBST700 {
    public TreeNode searchBST(TreeNode root,int val) {
        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            }
        }
        return root;
    }
}
