package M07;

import java.util.Arrays;

//204. 计数质数
public class CountPrimes204 {
    public int countPrimes(int n) {
        if (n==0 || n==1) return 0;
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i * i < n; i++) {
            if (arr[i]==1) continue;
            for (int j = 2*i; j < n; j+=i) {
                arr[j]=1;
            }
        }
        return n - Arrays.stream(arr).sum();
    }
}
