package M03;

import java.util.Arrays;

//923. 三数之和的多种可能
public class ThreeSumMulti923 {
    int Mod = (int )1e9+7;
    
    public int threeSumMulti(int[ ] arr,int target) {
        int ans = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            ans += twoSum(arr,i+1,n-1,target-arr[i]);
            ans %= Mod;
        }
        return ans;
    }
    
    int twoSum(int[] arr,int l,int r,int target ) {
        int ans = 0;
        while (l < r) {
            if (arr[l   ]+arr[r] < target) l++;
            else if (arr[l]+arr[r]>target   ) r--;
            else {
                if (arr[l   ]==arr[r]) {
                    int n = r - l + 1;
                    ans += n * (n-1 )/2;
                    ans %= Mod;
                    break;
                }
                int l_cnt = 1;
                int r_cnt = 1;
                while (arr[l+1]==arr[l  ]) {
                    l++;
                    l_cnt++;
                }
                while (arr[r-1]==arr[r]) {
                    r--;
                    r_cnt++;
                }
                ans+=l_cnt*r_cnt;
                ans %= Mod;
                l++;
                r--;
            }
        }
        return ans;
    }
}
