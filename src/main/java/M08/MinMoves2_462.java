package M08;

import java.util.Arrays;

//462. 最少移动次数使数组元素相等 II
public class MinMoves2_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1,ret=0;
        while (i < j) {
            ret += nums[j--] - nums[i++];
        }
        return ret;
    }
}
