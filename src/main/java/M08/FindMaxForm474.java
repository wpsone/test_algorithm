package M08;

//474. ⼀和零
public class FindMaxForm474 {
    //dp[k][i][j] = max(dp[k − 1][i][j], dp[k − 1][i − c0][j − c1])
//    public int findMaxForm(String[] strs,int m,int n) {
//        int l = strs.length;
//        int[][] cnt = new int[l + 1][2];
//        for (int i = 0; i < strs.length; i++) {
//            for (char c : strs[i].toCharArray()) {
//                if (c=='0') cnt[i+1][0]++;
//                else cnt[i+1][1]++;
//            }
//        }
//        int[][][] dp = new int[l + 1][m + 1][n + 1];
//        for (int k = 1; k <= l; k++) {
//            int cnt0=cnt[k][0],cnt1=cnt[k][1];
//            for (int i = 0; i <= m; i++) {
//                for (int j = 0; j <= n; j++) {
//                    dp[k][i][j] = dp[k - 1][i][j];
//                    if (i >= cnt0 && j >= cnt1) {
//                        dp[k][i][j]=Math.max(dp[k][i][j],dp[k-1][i-cnt0][j-cnt1]+1);
//                    }
//                }
//            }
//        }
//        return dp[l][m][n];
//    }


//    public int findMaxForm(String[] strs,int m,int n) {
//        int l = strs.length;
//        int[][] cnt = new int[l + 1][2];
//        for (int i = 0; i < strs.length; i++) {
//            for (char c : strs[i].toCharArray()) {
//                if (c=='0') cnt[i+1][0]++;
//                else cnt[i+1][1]++;
//            }
//        }
//        int[][][] dp = new int[2][m + 1][n + 1];
//        for (int k = 1; k <= l; k++) {
//            int ind = k % 2;
//            int pre_ind = 1 - ind;
//            int cnt0 = cnt[k][0],cnt1=cnt[k][1];
//            for (int i = 0; i <= m; i++) {
//                for (int j = 0; j <= n; j++) {
//                    dp[ind][i][j]=dp[pre_ind][i][j];
//                    if (i >= cnt0 && j >= cnt1) {
//                        dp[ind][i][j]=Math.max(dp[ind][i][j],dp[pre_ind][i-cnt0][j-cnt1]+1);
//                    }
//                }
//            }
//        }
//        return dp[l%2][m][n];
//    }


    public int findMaxForm(String[] strs,int m,int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int cnt0=0,cnt1=0;
            for (char c : str.toCharArray()) {
                if (c=='0') cnt0++;
                else cnt1++;
            }
            for (int i = m; i >= cnt0; i--) {
                for (int j = n; j >= cnt1; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-cnt0][j-cnt1]+1);
                }
            }
        }
        return dp[m][n];
    }
}
