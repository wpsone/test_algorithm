package M08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combine77 {
    public List<List<Integer>> combine(int n,int k ) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0,j=1; i < n; i++,j*=2) {
            map.put(j,i);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == k) {
                List<Integer> ans = new ArrayList<>();
                int val = i;
                while (val!=0) {
                    ans.add(nums[map.get(val&(-val))]);
                    val &= (val-1);
                }
                ret.add(ans);
            }
        }
        return ret;
    }
}
