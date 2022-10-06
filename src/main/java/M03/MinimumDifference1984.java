package M03;

import java.util.Arrays;

//1984. 学⽣分数的最⼩差值
public class MinimumDifference1984 {
    public int minimumDifference(int[] nums,int k) {
        Arrays.sort(nums);
        int i = 0,j=k-1,ans=-1;
        int n = nums.length;
        while (j < n) {
            if (ans==-1 || ans>nums[j]-nums[i])
                ans=nums[j]-nums[i  ];
            i++;
            j++;
        }
        return ans;
    }
}
