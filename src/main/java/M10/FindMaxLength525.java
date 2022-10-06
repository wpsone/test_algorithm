package M10;

import java.util.HashMap;
import java.util.Map;

//525. 连续数组
public class FindMaxLength525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        if (n<2) return 0;
        int[] sum = new int[n+1];
        map.put(0,0);
        for (int i = 0; i < n; i++) {
            if (nums[i]==1) continue;
            nums[i]=-1;
        }
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i  ];
            if (!map.containsKey(sum[i+1]))
                map.put(sum[i+1],i+1);
        }
        int ans = 0;
        for (int i = n; i >= 0; i--) {
            if (map.containsKey(sum[i])) {
                ans = Math.max(ans,i-map.get(sum[i]));
            }
        }
        return ans;
    }
}
