package M08;

public class MinCost256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i]=costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int ind = i % 2;
            int pre_ind = (ind == 1 ? 0 : 1);
            dp[ind][0] = Math.min(dp[pre_ind][1],dp[pre_ind][2]) + costs[i][0];
            dp[ind][1] = Math.min(dp[pre_ind][0],dp[pre_ind][2]) + costs[i][1];
            dp[ind][2] = Math.min(dp[pre_ind][1],dp[pre_ind][0]) + costs[i][2];
        }
        int ind = (n-1)%2;
        return Math.min(dp[ind][0],Math.min(dp[ind][1],dp[ind][2]));
    }
}
