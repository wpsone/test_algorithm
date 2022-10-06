package M07;

import M07.Utils.*;

//1367. ⼆叉树中的列表
public class IsSubPath1367 {
    public boolean isSubPath(ListNode head,TreeNode root) {
        if (root==null) return false;
        return dfs(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    public boolean dfs(ListNode head,TreeNode root) {
        if (head==null) return true;
        if (root==null) return false;
        if (head.val != root.val) return false;
        return dfs(head.next,root.left) || dfs(head.next,root.right);
    }
}
