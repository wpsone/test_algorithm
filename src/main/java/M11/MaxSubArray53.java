package M11;

import java.util.Deque;
import java.util.LinkedList;

//53. 最⼤⼦数组和
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] min = new int[n];
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i!=0) min[i] = Math.min(min[i-1],nums[i-1]);
            ans = Math.max(ans,nums[i]-min[i]);
        }
        return ans;
    }
}
