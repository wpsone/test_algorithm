package M09;

import java.util.Arrays;

//611. 有效三角形的个数
public class TriangleNumber611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = n-1; i > 1; i--) {
            int l=0,r=i-1;
            while (l < r) {
                if (nums[l]+nums[r]>nums[i]){
                    ans+=r-l;
                    r-=1;
                } else {
                    l+=1;
                }
            }
        }

//        for (int i = 0; i < n - 2; i++) {
//            for (int j = i+1; j < n - 1; j++) {
//                int t = nums[i]+nums[j];
//                int l = j + 1,r=n-1;
//                while (l < r) {
//                    int mid = l+r+1>>1;
//                    if (nums[mid]<t) l=mid;
//                    else r=mid-1;
//                }
//                if (nums[r] < t) {
//                    ans+=r-j;
//                }
//            }
//        }
        return ans;
    }
}
