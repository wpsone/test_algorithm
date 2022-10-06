package M03;

//1302. 层数最深叶⼦节点的和
public class DeepestLeavesSum1302 {
    int ans,max_k;
    
    public int deepestLeavesSum(TreeNode root) {
        ans = 0;
        max_k = 0;
        getAns(root,0);
        return ans;
    }
    
    private void getAns(TreeNode root,int k) {
        if (root == null) return;
        if (k == max_k) ans+=root.val;
        else if (k > max_k) {
            max_k=k;
            ans = root.val;
        }
        getAns(root.left,k+1);
        getAns(root.right,k+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}

    TreeNode(int val) {this.val = val;}

    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
