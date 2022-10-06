package M12;

//926. 将字符串翻转到单调递增
public class MinFlipsMonoIncr926 {
//    public int minFlipsMonoIncr(String s) {
//        int ans,n0 = 0,n1=0;
//        for (char x : s.toCharArray()) {
//            if (x=='0') n0+=1;
//        }
//        ans=n0;
//        for (char x : s.toCharArray()) {
//            if (x=='0') n0 -= 1;
//            else n1+=1;
//            ans = Math.min(ans,n0+n1);
//        }
//        return ans;
//    }

//    public int minFlipsMonoIncr(String s) {
//        int n = s.length();
//        int[] sum = new int[n];
//        sum[0] = s.charAt(0)-'0';
//        for (int i = 1; i < n; i++) {
//            sum[i] = sum[i-1] + s.charAt(i) - '0';
//        }
//        int min = n - sum[n-1];
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i)=='0') {
//                int num1 = sum[i];
//                int num0 = n - 1 - i - (sum[n-1]-sum[i]);
//                if (min>num1+num0) min = num0+num1;
//            }
//        }
//        return min;
//    }

//    public int minFlipsMonoIncr(String s) {
//        int n = s.length();
//        int[] dp = new int[2];
//        dp[0] = s.charAt(0) - '0';
//        dp[1] = 1 - dp[0];
//        for (int i = 1; i < n; i++) {
//            if (s.charAt(i)=='0') {
//                dp[1] = Math.min(dp[1],dp[0]) + 1;
//            } else {
//                dp[1] = Math.min(dp[1],dp[0]);
//                dp[0] += 1;
//            }
//        }
//        return Math.min(dp[0],dp[1]);
//    }

    public int minFlipsMonoIncr(String s) {
        int ans,n0=0,n1=0;
        for (char x : s.toCharArray()) {
            if (x=='0') n0+=1;
        }
        ans=n0;
        for (char x : s.toCharArray()) {
            if (x=='0') n0-=1;
            else n1+=1;
            ans = Math.min(ans,n0+n1);
        }
        return ans;
    }
}
