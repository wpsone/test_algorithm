package M03;

//1911. 最⼤⼦序列交替和
public class MaxAlternatingSum1911 {
    public long maxAlternatingSum(int[] nums) {
        long n = nums.length, ans = nums[0];
        long sub_max = 0, add_max = nums[0];
        for (int i = 1; i < n; i++) {
            long a = Math.max(sub_max + nums[i],nums[i]);
            long b = add_max - nums[i];
            ans = Math.max(ans,Math.max(a,b));
            add_max = Math.max(add_max,a    );
            sub_max = Math.max(sub_max,b);
        }
        return ans;
    }
}
