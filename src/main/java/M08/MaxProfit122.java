package M08;

public class MaxProfit122 {
    //动态转换方程
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int[][] dp = new int[2][2];
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//        for (int i = 1; i < n; i++) {
//            int ind = i %2;
//            int pre_ind = 1-ind;
//            dp[ind][0]=Math.max(dp[pre_ind][0],dp[pre_ind][1]+prices[i]);
//            dp[ind][1]=Math.max(dp[pre_ind][1],dp[pre_ind][0]-prices[i]);
//        }
//        return dp[(n-1)%2][0]>dp[(n-1)%2][1]?dp[(n-1)%2][0]:dp[(n-1)%2][1];
//    }

    //贪心
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]-prices[i-1]>0) ans+=prices[i]-prices[i-1];
        }
        return ans;
    }
}
