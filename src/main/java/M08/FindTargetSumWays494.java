package M08;

import java.util.Arrays;

//494. ⽬标和
public class FindTargetSumWays494 {
    public int findTargetSumWays(int[] nums,int target) {
        int sum = Arrays.stream(nums).sum(),n=nums.length;
        if (sum<Math.abs(target)) return 0;
        int[][] dp = new int[2][2 * sum + 1];
        int I = sum;
        sum = 0;
        dp[0][I] = 1;
        for (int i = 1; i <= n; i++) {
            int ind = i%2;
            int pre_ind = 1 - ind;
            int x=nums[i-1];
            Arrays.fill(dp[ind],0);
            for (int j = -sum; j <= sum; j++) {
                dp[ind][j+I+x]+=dp[pre_ind][j+I];
                dp[ind][j+I-x]+=dp[pre_ind][j+I];
            }
            sum+=x;
        }
        return dp[n%2][I+target];
    }
}
