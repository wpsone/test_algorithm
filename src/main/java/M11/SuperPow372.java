package M11;

//372. 超级次⽅
public class SuperPow372 {
    private int power(int a,int b,int mod) {
        int x = a % mod,ans = 1;
        while (b != 0) {
            if ((b&1)==1) ans = ans * x % mod;
            x = x * x % mod;
            b >>= 1;
        }
        return ans;
    }

    public int superPow(int a,int[] b) {
        int ans = 1,mod = 1337, x =a ;
        for (int i = b.length-1; i >= 0; i--) {
            ans = ans * power(x,b[i],mod) % mod;
            x = power(x,10,mod);
        }
        return ans;
    }
}
