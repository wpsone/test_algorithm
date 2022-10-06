package M03;

//1987. 不同的好⼦序列数⽬
public class NumberOfUniqueGoodSubsequences1987 {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int n = binary.length();
        int mod_num = (int) 1e9 + 7;
        int dp[][] = new int[n][2];
        int num = binary.charAt(n-1)-'0';
        int flag = num^1;
        dp[n-1][0]=1^num;
        dp[n-1][1]=0^num;
        for (int i = n-2; i >= 0; i--) {
            int j = binary.charAt(i)-'0';
            if (j==0) flag = 1;
            dp[i][j] = dp[i+1][j]+1+dp[i+1][1-j];
            dp[i][1-j] = dp[i+1][1-j];
            dp[i][j] %= mod_num;
            dp[i][1-j] %= mod_num;
        }
        return dp[0][1]+flag;
    }
}
