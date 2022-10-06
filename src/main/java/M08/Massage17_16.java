package M08;

//⾯试题 17.16. 按摩师
public class Massage17_16 {
    public int massage(int[] nums) {
        if (nums.length==0) return 0;
        int n = nums.length;
        int[][] dp = new int[2][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int ind = i % 2;
            int pre_ind = 1 - ind;
            dp[ind][0] = Math.max(dp[pre_ind][0],dp[pre_ind][1]);
            dp[ind][1]=dp[pre_ind][0]+nums[i       ];
        }
        return Math.max(dp[(n-1)%2][0],dp[(n-1)%2][1]);
    }
}
