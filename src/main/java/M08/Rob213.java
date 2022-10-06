package M08;

//213. 打家劫舍 II
public class Rob213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        int[][] dp = new int[2][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < n; i++) {
            int ind = i % 2;
            int pre_ind = 1 - ind;
            dp[ind][0] = Math.max(dp[pre_ind][0],dp[pre_ind][1]);
            dp[ind][1] = dp[pre_ind][0]+nums[i];
        }
        int ans = dp[(n-1)%2][0];

        dp[0][0]=0;
        dp[0][1]=1;
        for (int i = 1; i < n; i++) {
            int ind = i %2;
            int pre_ind = 1 - ind;
            dp[ind][0]=Math.max(dp[pre_ind][0],dp[pre_ind][1]);
            dp[ind][1]=dp[pre_ind][0]+nums[i    ];
        }
        ans=Math.max(ans,dp[(n-1)%2][1]);
        return ans;
    }
}
