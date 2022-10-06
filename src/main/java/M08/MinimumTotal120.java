package M08;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal120 {
    //自顶向下
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[][] dp = new int[2][n];
//        dp[0][0] = triangle.get(0).get(0);
//        for (int i = 1; i < n; i++) {
//            int ind = i % 2;
//            int pre_ind = (ind==1?0:1);
//            int j=0;
//            //第一行 与 斜边特殊处理
//            while (j<i) {
//                if (j==0) dp[ind][0] = dp[pre_ind][0] + triangle.get(i).get(0);
//                else dp[ind][j] = Math.min(dp[pre_ind][j-1],dp[pre_ind][j])+triangle.get(i).get(j);
//                j++;
//            }
//            dp[ind][j]=dp[pre_ind][j-1]+ triangle.get(i).get(j);
//        }
//        return Arrays.stream(dp[(n-1)%2]).min().getAsInt();
//    }

    //自底向上
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[][] dp = new int[2][n];
//        for (int i = 0; i < n; i++) {
//            dp[(n-1)%2][i] = triangle.get(n-1).get(i);
//        }
//        for (int i = n-2; i >= 0; i--) {
//            int ind = i % 2;
//            int next_ind = (ind==0?1:0);
//            for (int j = 0; j <= i; j++) {
//                dp[ind][j]=Math.min(dp[next_ind][j],dp[next_ind][j+1])+triangle.get(i).get(j);
//            }
//        }
//        return dp[0][0];
//    }

    //动态规划算法
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        int[][] dp = new int[n][n];
//        for (int[] arr : dp) {
//            Arrays.fill(arr,Integer.MAX_VALUE);
//        }
//        dp[0][0] = triangle.get(0).get(0);
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j <= i; j++) {
//                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+triangle.get(i+1).get(j));
//                dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j]+triangle.get(i+1).get(j+1));
//            }
//        }
//        int ans = Integer.MAX_VALUE;
//        for (int x :
//                dp[n - 1]) {
//            ans = Math.min(x, ans);
//        }
//        return ans;
//    }

    //滚动数组
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];
        for (int[] arr : dp) {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 0; i < n - 1; i++) {
            int ind = i % 2;
            int next_ind = 1 - ind;
            for (int j = 0; j <= i; j++) {
                dp[next_ind][j] = Math.min(dp[next_ind][j],dp[ind][j]+triangle.get(i+1).get(j));
                dp[next_ind][j+1] = Math.min(dp[next_ind][j+1],dp[ind][j]+triangle.get(i+1).get(j+1));
            }
            Arrays.fill(dp[ind],Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int x : dp[(n - 1) % 2]) {
            ans=Math.min(x,ans);
        }
        return ans;
    }
}
