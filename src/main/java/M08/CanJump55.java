package M08;

//55. 跳跃游戏
public class CanJump55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n==1) return true;
        int pre = nums[0];
        int cur = 0;
        for (int i = 1; i < n; i++) {
            cur = pre>=i?Math.max(pre,nums[i]+i):pre;
            pre = cur;
        }
        return pre >= n-1;
    }
}
