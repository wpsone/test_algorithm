package M12;

import java.util.Arrays;

//1819. 序列中不同最⼤公约数的数⽬
public class CountDifferentSubsequenceGCDs1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] arr = new int[200005];
        int max = Arrays.stream(nums).max().getAsInt();
        for (int num : nums) {
            arr[num]++;
        }
        int cnt = 0;
        for (int i = 1; i <= max; i++) {
            int t = -1;
            for (int j = 1; j <= max / i; j++) {
                if (arr[i*j]==0) continue;
                if (t==-1) t=i*j;
                else t = gcd(t,i*j);
            }
            if (t==i) cnt++;
        }
        return cnt;
    }
    public int gcd(int a,int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
