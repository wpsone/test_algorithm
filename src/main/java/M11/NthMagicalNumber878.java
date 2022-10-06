package M11;

//878. 第 N 个神奇数字
public class NthMagicalNumber878 {
    long gcd(long a,long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    long lcm(long a,long b) {
        return a*b/gcd(a,b);
    }

    long f(long x,long a,long b) {
        return x/a + x/b - x/lcm(a,b);
    }

    public int nthMagicalNumber(int n,int a,int b) {
        long l = 2, r = (long) n * Math.min(a,b),mid,mod=(long)(1e9+7);
        while (l<r) {
            mid = (r-l)/2 + l;
            if (f(mid,a,b)<n) l = mid + 1;
            else r = mid;
        }
        return (int) (l % mod);
    }
}
