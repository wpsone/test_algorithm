package M08;

//322. 零钱兑换
public class CoinChange322 {
    //动态转移⽅程：dp[n] = dp[n − x] + 1;
    public int coinChange(int[] coins,int amount) {
        int[] dp = new int[amount + 1];
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            dp[i]=-1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i<coin) continue;
                if (dp[i-coin]==-1) continue;
                if (dp[i]==-1 || dp[i]>dp[i-coin]+1 ) dp[i]=dp[i-coin]+1;
            }
        }
        return dp[amount];
    }
}
