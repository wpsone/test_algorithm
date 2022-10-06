package M08;

//276. 栅栏涂⾊
public class NumWays276 {
//    动态转移⽅程： dp[n][0] = dp[n − 1][1]; dp[n][1] = (dp[n − 1][0] + dp[n − 1][1]) ∗ (k − 1);
//    public int numWays(int n,int k) {
//        if (k==1) return n>2?0:1;
//        if (n<=2) return (int) Math.pow(k,n);
//        // 0：和前⾯⼀样 1：和前⾯不⼀样
//        int[][] dp = new int[2][2];
//        dp[0][1]=k;
//        for (int i = 1; i < n; i++) {
//            int ind = i % 2;
//            int pre_ind=1-ind;
//            dp[ind][0]=dp[pre_ind][1];
//            dp[ind][1]=(dp[pre_ind][0]+dp[pre_ind][1])*(k-1);
//        }
//        return dp[(n-1)%2][0]+dp[(n-1)%2][1];
//    }

    //动态转移⽅程： dp[n] = dp[n − 1] ∗ (k − 1) + dp[n − 2] ∗ (k − 1)
    public int numWays(int n,int k) {
        if (k==1) return n>2?0:1    ;
        if (n<=2) return (int)Math.pow(k,n);
        int[] dp = new int[2];
        dp[0]=k;
        dp[1]=k*k;
        for (int i = 2; i < n; i++) {
            int ind = i %2;
            int pre_ind = 1 - ind;
            dp[ind] = (dp[pre_ind]+dp[ind])*(k-1);
        }
        return dp[(n-1)%2];
    }
}
