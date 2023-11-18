package Leetcode.简单;

import java.util.Arrays;

public class K个元素的最大和 {
    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum = maxSum + max;
            max += 1;
        }
//        return maxSum;
        return (2 * maxSum + k - 1) * k / 2;
    }
}
