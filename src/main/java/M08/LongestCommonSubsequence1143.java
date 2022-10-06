package M08;

//1143. 最⻓公共⼦序列
public class LongestCommonSubsequence1143 {
//    public int longestCommonSubsequence(String text1,String text2) {
//        int n = text1.length();
//        int m = text2.length();
//        int[][] dp = new int[2][m + 1];
//        for (int i = 1; i < n; i++) {
//            int ind = i % 2;
//            int pre_ind = 1 - ind;
//            for (int j = 1; j <= m; j++) {
//                dp[ind][j   ] = Math.max(dp[pre_ind][j],dp[ind][j-1]);
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    dp[ind][j]=Math.max(dp[ind][j],dp[pre_ind][j-1]+1);
//                }
//            }
//        }
//        return dp[n%2][m];
//    }

    public int longestCommonSubsequence(String text1,String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[2][m + 1];
        for (int i = 0; i <= n; i++) {
            int ind = i % 2;
            int next_ind = 1 - ind;
            for (int j = 0; j <= m; j++) {
                if (i+1<=n ) dp[next_ind][j] = Math.max(dp[ind][j],dp[next_ind][j]);
                if (j+1<=m) dp[ind][j+1]=Math.max(dp[ind][j],dp[ind][j+1]);
                if (i<n&&j<m && text1.charAt(i)==text2.charAt(j)) {
                    dp[next_ind][j+1]=Math.max(dp[ind][j]+1,dp[next_ind][j+1]);
                }
            }
        }
        return dp[n%2][m];
    }
}
