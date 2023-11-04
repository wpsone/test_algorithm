package Leetcode.简单;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import java.util.*;

public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int p = 0;
//        int q = 1;
//        while (q < nums.length) {
//            if (nums[p] != nums[q]) {
//                if (q - p > 1) {
//                    nums[p + 1] = nums[q];
//                }
//                p++;
//            }
//            q++;
//        }
//        return p + 1;

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        删除有序数组中的重复项 test = new 删除有序数组中的重复项();
        int[] input = {1, 1, 2};
        int i = test.removeDuplicates(input);
    }
}
