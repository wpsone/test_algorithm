package M08;

//650. 只有两个键的键盘
public class MinSteps650 {
    public int minSteps(int n) {
        if (n==1) return 0;
        int[] dp = new int[n + 1];
        dp[1]=0;
        for (int i = 2; i <= n; i++) {
            if (is_prime(i)) {
                dp[i]=i;
            } else {
                int j = get_big_factor(i);
                dp[i]=dp[j]+i/j;
            }
        }
        return dp[n];
    }

    private int get_big_factor(int n) {
        for (int i = n-1; i >= 1; i--) {
            if (n%i==0) return i;
        }
        return 1;
    }

    private boolean is_prime(int n) {
        if (n==2) return true;
        if (n%2==0) return false;
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n%i==0  ) return false;
        }
        return true;
    }
}
