package M08;

//1039. 多边形三⾓剖分的最低得分
public class MinScoreTriangulation1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j= i+len;
                dp[i][j]=Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    dp[i][j]=Math.min(values[i]*values[j]*values[k]+dp[i][k]+dp[k][j],dp[i  ][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
