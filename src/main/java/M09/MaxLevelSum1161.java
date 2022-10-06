package M09;

import M09.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

//1161. 最大层内元素和
public class MaxLevelSum1161 {
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int depth = 0;
        int res = 1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            depth++;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                temp+=cur.val;
                if (cur.left!=null) queue.offer(cur.left);
                if (cur.right!=null) queue.offer(cur.right);
            }
            if (temp > max) {
                max=temp;
                res = depth;
            }
        }
        return res;
    }
}
