package M08;

//123. 买卖股票的最佳时机 III
public class MaxProfit123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        //0 不买不卖， 1；买⼊⼀次，2,买⼊⼀次卖出⼀次，3买⼊两次卖出⼀次，4买⼊两次卖出两次
        int[][] dp = new int[2][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for (int i = 1; i < n; i++) {
            int ind = i % 2;
            int pre_ind = 1-ind;
            dp[ind][0]=dp[pre_ind][0];
            dp[ind][1]=Math.max(dp[pre_ind][1],dp[pre_ind][0]-prices[i]);
            dp[ind][2]=Math.max(dp[pre_ind][2],dp[pre_ind][1]+prices[i]);
            dp[ind][3]=Math.max(dp[pre_ind][3],dp[pre_ind][2]-prices[i]);
            dp[ind][4]=Math.max(dp[pre_ind][4],dp[pre_ind][3]+prices[i]);
        }
        return dp[(n-1)%2][4];
    }

}
