package M08;

import java.util.ArrayList;
import java.util.List;

//376. 摆动序列
public class WiggleMaxLength376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i]!=nums[i-1]) list.add(nums[i]);
        }
        n=list.size();
        if (n<=2) return n;
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            if ((list.get(i) - list.get(i - 1)) * (list.get(i - 1) - list.get(i - 2)) < 0) {
                dp[i]=dp[i-1]+1;
            } else {
                dp[i]=dp[i-1];
            }
        }
        return dp[n-1];
    }
}
