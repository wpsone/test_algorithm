package M08;

import java.util.Arrays;

//416. 分割等和⼦集
public class CanPartition416 {
    //f[i][j] = f[i − 1][j]orf[i − 1][j − x]
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2!=0) return false;
        int[] f = new int[sum + 1];
        f[0]=1;
        sum=0;
        for (int num : nums) {
            sum+=num;
            for (int i = sum; i >= num; i--) {
                f[i]|=f[i-num];
            }
        }
        return f[sum/2]==1;
    }
}
