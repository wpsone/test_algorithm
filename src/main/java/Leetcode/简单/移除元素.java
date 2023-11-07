package Leetcode.简单;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        int left = 0;
//        for (int right = 0; right < n; right++) {
//            if (nums[right] != val) {
//                nums[left] = nums[right];
//                left++;
//            }
//        }
//        return left;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
