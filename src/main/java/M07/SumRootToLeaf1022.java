package M07;

import M07.Utils.*;

//1022. 从根到叶的⼆进制数之和
public class SumRootToLeaf1022 {
    public int sumRootToLeaf(TreeNode root   ) {
        return sumRootToLeaf(root,0);
    }

    public int sumRootToLeaf(TreeNode root,int sum) {
        if (root==null) return 0;
        sum = (sum<<1)+root.val;
        if (root.left==null && root.right == null) return sum;
        return sumRootToLeaf(root.left,sum)+sumRootToLeaf(root.right,sum);
    }
}
