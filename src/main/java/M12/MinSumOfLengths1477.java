package M12;

import java.util.ArrayList;
import java.util.List;

//1477. 找两个和为⽬标值且不重叠的⼦数组
public class MinSumOfLengths1477 {
    public int minSumOfLengths(int[] arr,int target) {
        int l = 0, n = arr.length, sum = 0;
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target && l <= r) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                list.add(new int[]{l,r});
            }
        }
        int pre_ind = -1,pre_len = n + 1, ans = -1;
        for (int[] x : list) {
            while (list.get(pre_ind+1)[1]<x[0]) {
                pre_ind++;
                pre_len = Math.min(pre_len,list.get(pre_ind)[1]-list.get(pre_ind)[0]+1);
            }
            if (pre_ind==-1) continue;
            if (ans == -1 || ans > pre_len + x[1] - x[0] + 1) {
                ans = pre_len + x[1]-x[0]+1;
            }
        }
        return ans;
    }
}
