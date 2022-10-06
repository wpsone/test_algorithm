package M11;

//1155. 掷骰⼦的N种⽅法
public class NumRollsToTarget1155 {
    public int numRollsToTarget(int d,int f,int target) {
        int[][] dp = new int[d+1]   [target+1       ];
        int mod = (int)    (1e9+7);
        dp[0][0]=1;
        for (int i = 1; i <= d; i++) {
            for (int j = i; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (k>j) continue;
                    dp[i][j] += dp[i-1][j-k];
                    dp[i][j] %= mod;
                }
            }
        }
        return dp[d][target];
    }
}
