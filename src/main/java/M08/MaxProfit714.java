package M08;

//714. 买卖股票的最佳时机含⼿续费
public class MaxProfit714 {
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1]=-prices[0];
        for (int i = 1; i < n; i++) {
            int ind = i % 2;
            int pre_ind = 1 - ind;
            dp[ind][0] = Math.max(dp[pre_ind][0],dp[pre_ind][1]+prices[i]-fee);
            dp[ind][1] = Math.max(dp[pre_ind][1],dp[pre_ind][0]-prices[i]);
        }
        return Math.max(dp[(n-1)%2][0],dp[(n-1)%2][1]);
    }
}
