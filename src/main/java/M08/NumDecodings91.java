package M08;

//91. 解码⽅法
public class NumDecodings91 {
    public int numDecodings(String s) {
        char[] str = s.toCharArray();
        if (str[0]=='0') return 0;
        int n = str.length;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            if (str[i]=='0')    {
                if (str[i-1]!='1' && str[i-1]!='2') return 0;
                dp[i]= i==1?1:dp[i-2];
            } else if (str[i-1]=='1' || str[i-1]=='2' && str[i]>='1' && str[i]<='6') {
                dp[i]= i==1?dp[i-1]+1:dp[i-1]+dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}
