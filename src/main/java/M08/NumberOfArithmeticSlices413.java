package M08;

import java.util.Arrays;

//413. 等差数列划分
public class NumberOfArithmeticSlices413 {
//    public int numberOfArithmeticSlices(int[] nums) {
//        int n = nums.length;
//        if (n<3) return 0;
//        int[] dp = new int[n];
//        for (int i = 2; i < n; i++) {
//            if (nums[i]+nums[i-2]==2*nums[i-1]) {
//                dp[i]=dp[i-1]+1;
//            }
//        }
//        return Arrays.stream(dp).sum();
//    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n<3) return 0;
        int[] dp = new int[n];
        for (int i = 2,j=1; i < n; i++) {
            if (nums[i]+nums[i-2]==2*nums[i-1]) {
                dp[i]=dp[i-1]+i-j;
            } else {
                dp[i]=dp[i-1];
                j=i;
            }
        }
        return dp[n-1];
    }
}
