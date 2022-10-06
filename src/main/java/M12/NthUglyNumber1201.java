package M12;

//1201. 丑数 III
public class NthUglyNumber1201 {
    public int nthUglyNumber(int n,int a,int b,int c) {
        Checker checker = new Checker(a, b, c);
        long l = 1,r = n * Math.min(a,Math.min(b,c)),mid = 0;
        while (l < r) {
            mid = l + r >> 1;
            if (checker.get(mid)<n) l = mid + 1;
            else r = mid;
        }
        return (int) l;
    }
}

class Checker {
    long a,b,c,ab,bc,ac,abc;

    public Checker(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.ab = lcm(a,b);
        this.ac = lcm(a,c);
        this.bc = lcm(c,b);
        this.abc = lcm(c,lcm(a,b));
    }

    long gcd(long x,long y) {
        if (y==0) return x;
        return gcd(y,x%y);
    }

    long lcm(long x,long y) {
        return x*y/gcd(x,y);
    }

    public long get(long n) {
        return n/a + n/b + n/c - n/ab - n/ac - n/bc + n/abc;
    }
}
