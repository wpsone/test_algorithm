package M12;

//LCP 02. 分式化简
public class Fraction_LCP02 {
    public int[] fraction(int[] cont) {
        int m = 1;
        int n = 0;
        for (int i = cont.length-1; i >= 0; i--) {
            m ^= n;
            n ^= m;
            m ^= n;
            m += n * cont[i];
            int r = gcd(m,n);
            m /= r;
            n /= r;
        }
        int[] ret = new int[2];
        ret[0] = m;
        ret[1] = n;
        return ret;
    }

    public int gcd(int m,int n) {
        if (n==0) return m;
        return gcd(n,m%n);
    }
}
