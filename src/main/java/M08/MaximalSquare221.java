package M08;

//221. 最⼤正⽅形
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]=='1') {
                    if (i == 0 || j == 0) {
                        dp[i][j]=1;
                    } else {
                        dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]);
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1])+1;
                    }
                    len=Math.max(len,dp[i][j]);
                }
            }
        }
        return len*len;
    }
}
