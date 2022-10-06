package M08;

//70. 爬楼梯
public class ClimbStairs70 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int p=1;
        int q=2;
        for (int i = 3; i <= n; i++) {
            q=p+q;
            p=q-p;
        }
        return q;
    }
}
