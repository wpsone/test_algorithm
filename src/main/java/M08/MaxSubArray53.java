package M08;

//53. 最⼤⼦序和
public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
        }
        int pre = 0,ret = Integer.MIN_VALUE;
        for (int num : nums) {
            ret = Math.max(num-pre,ret);
            pre = Math.min(pre,num);
        }
        return ret;
    }
}
