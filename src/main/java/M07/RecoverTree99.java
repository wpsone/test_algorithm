package M07;

import M07.Utils.*;

public class RecoverTree99 {
    TreeNode p,q,pre;

    public void recoverTree(TreeNode root) {
        p = q = pre = null;
        inorder(root);
        int t = q.val;
        q.val=p.val;
        p.val=t;
    }

    public void inorder(TreeNode root) {
        if (root==null) return;
        inorder(root.left);
        if (pre!=null && pre.val>root.val) {
            if (p==null) p = pre;
            q=root;
        }
        pre = root;
        inorder(root.right);
    }
}
