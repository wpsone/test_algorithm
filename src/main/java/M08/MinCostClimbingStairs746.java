package M08;

//746. 使⽤最⼩花费爬楼梯
public class MinCostClimbingStairs746 {
    //动态转移⽅程：dp[n] = min(dp[n − 1]，dp[n − 2]) + cost[n]
//    public int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length + 1];
//        dp[0]=cost[0];
//        dp[1]=cost[1];
//        for (int i = 2; i <= cost.length; i++) {
//            if (i<cost.length) dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
//            else dp[i]=Math.min(dp[i-1],dp[i-2]);
//        }
//        return dp[dp.length-1];
//    }

    //滚动数组
    public int minCostClimbingStairs(int[] cost) {
        int p = cost[0];
        int q = cost[1];
        int ans = 0;
        for (int i = 2; i <= cost.length; i++) {
            if (i < cost.length) {
                ans=cost[i]+Math.min(p,q);
                p=q;
                q=ans;
            } else {
                ans = Math.min(p,q);
            }
        }
        return ans;
    }
}
