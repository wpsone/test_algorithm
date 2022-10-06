package M08;

//198. 打家劫舍
public class Rob198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < n; i++) {
            int ind = i % 2;
            int pre_ind = (ind==1?0:1);
            dp[ind][0]=Math.max(dp[pre_ind][0],dp[pre_ind][1]);
            dp[ind][1]=dp[pre_ind][0]+nums[i   ];
        }
        return Math.max(dp[(n-1)%2][0],dp[(n-1)%2][1]);
    }
}
