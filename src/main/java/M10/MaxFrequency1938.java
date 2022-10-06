package M10;

import java.util.*;

//1838. 最⾼频元素的频数
public class MaxFrequency1938 {

    public int maxFrequency(int[] nums,int k) {
        int n = nums.length;
        if (n==1) return 1;
        Arrays.sort(nums);
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int l = 0,r = 2, ans = 0;
        while (r<=n) {
            if (sum[r] - sum[l] + k >= nums[r-1]*(r-l)) {
                ans = Math.max(ans,r-l);
                r++;
            } else {
                while (sum[r]-sum[l]+k<nums[r-1]*(r-l)) l++;
            }
        }

        return ans;
    }
}
