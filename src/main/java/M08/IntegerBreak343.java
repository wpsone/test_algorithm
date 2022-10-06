package M08;

//343. 整数拆分
public class IntegerBreak343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = i-1; j > (i - 1) / 2; j--) {
                dp[i]=Math.max(dp[i],j*(i-j));
                dp[i]=Math.max(dp[i],dp[j]*(i-j));
                dp[i]=Math.max(dp[i],j*dp[(i-j)]);
                dp[i]=Math.max(dp[i],dp[j]*dp[(i-j)]);
            }
        }
        return dp[n];
    }
}
