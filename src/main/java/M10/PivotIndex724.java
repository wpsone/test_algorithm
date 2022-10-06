package M10;

import java.util.Arrays;

//724. 寻找数组的中⼼下标
public class PivotIndex724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * temp + nums[i] == sum) {
                return i;
            }
            temp += nums[i];
        }
        return -1;
    }
}
