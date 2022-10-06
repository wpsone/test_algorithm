package M08;

import java.util.Random;

public class Solution528 {
    int[] sum;
    int n;

    public Solution528(int[] w) {
        sum=w;
        for (int i=1;i<sum.length;i++) {
            sum[i]+=sum[i-1];
        }
        n=sum[sum.length-1];
    }

    public int pickIndex() {
        Random random = new Random();
        int x = random.nextInt(n);
        int l=0,r=sum.length-1;
        while (l < r) {
            int m=(l+r)>>1;
            if (sum[m]<=x) l=m+1;
            else r=m;
        }
        return l;
    }
}
