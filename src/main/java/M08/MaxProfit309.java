package M08;

import java.util.Arrays;

//309. 最佳买卖股票时机含冷冻期
public class MaxProfit309 {
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int[][] dp = new int[n][3];
//        // 0:⾮冻不持股 1:持股 2:冻结不持股
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//        dp[0][2]=0;
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
//            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//            dp[i][2] = dp[i-1][1]+prices[i];
//        }
//        return Arrays.stream(dp[n-1]).max().getAsInt();
//    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][3];
        // 0:⾮冻不持股 1:持股 2:冻结不持股
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        for (int i = 1; i < n; i++) {
            int ind=i%2;
            int pre_ind=1-ind;
            dp[ind][0]=Math.max(dp[pre_ind][0],dp[pre_ind][2]);
            dp[ind][1]=Math.max(dp[pre_ind][1],dp[pre_ind][0]-prices[i]);
            dp[ind][2]=dp[pre_ind][1]+prices[i];
        }
        return Arrays.stream(dp[(n-1)%2]).max().getAsInt();
    }
}
