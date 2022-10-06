package M11;

//1175. 质数排列
public class NumPrimeArrangements1175 {
    long mod;

    public int numPrimeArrangements(int n) {
        int cnt = cnt_prime(n);
        mod = (long) (1e9+7);
        return (int) (frac(cnt)*frac(n-cnt)%mod);
    }

    public long frac(int n) {
        long ans = 1;
        for (int i = n; i >= 1; i--) {
            ans = ans * i % mod;
        }
        return ans;
    }

    //N=p*M
    public int cnt_prime(int n) {
        int[] prime = new int[n+5];
        // 素数筛：质数 线性筛：M
        for (int i = 2; i <= n; i++) {
            if (prime[i]==0) {
                prime[++prime[0]] = i;
            }
            // 素数筛：倍数 线性筛：质数
            for (int j = 1; j <= prime[0]; j++) {
                if (prime[j]*i > n) break;
                prime[prime[j]*i] = 1;
                if (i%prime[j]==0) break;
            }
        }
        return prime[0];
    }

    public int cnt_prime1(int n ) {
        int[] prime = new int[n+5];
        for (int i = 2; i <= n; i++) {
            if (prime[i]==1) continue;
            prime[0]++;
            for (int j = i; j <= n / i; j++) {
                prime[i*j]=1;
            }
        }
        return prime[0];
    }

}
