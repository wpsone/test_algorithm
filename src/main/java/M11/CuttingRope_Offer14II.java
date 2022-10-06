package M11;

//剑指 Offer 14- II. 剪绳⼦ II
public class CuttingRope_Offer14II {
    public int cuttingRope(int n) {
        if (n<=3) return n-1;
        int mod = 1000000007;

        long sum = 1;
        while (n>4) {
            sum = sum * 3 % mod;
            n -= 3;
        }
        return (int) (sum * n % mod);
    }
}
