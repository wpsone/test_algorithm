package M08;

//300. 最⻓递增⼦序列
public class LengthOfLIS300 {
    //动态转移⽅程：dp[n] = max(dp[0] + 1到dp[n − 1] + 1, dp[n]);
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[j]>=nums[i]) continue;
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}
