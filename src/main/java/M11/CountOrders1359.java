package M11;

//1359. 有效的快递序列数⽬
public class CountOrders1359 {
    public int countOrders(int n) {
        long ans = 1,mod = (long)(1e9+7);
        for (int i = 2; i <= n; i++) {
            ans = ans * (2*i*i-i)%mod;
        }
        return (int) ans;
    }
}
