package M08;

//剑指 Offer II 094. 最少回⽂分割
public class MinCutOfferII094 {

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i]=i;
            for (int j = 0; j < i; j++) {
                if (is_palindrome(s,j,i-1)) {
                    dp[i]=Math.min(dp[j]+1,dp[i]);
                }
            }
        }
        return dp[n]-1;
    }

    private boolean is_palindrome(String s,int i,int j) {
        while (i <= j) {
            if (s.charAt(i)!=s.charAt(j     )) return false;
            i++;
            j--;
        }
        return true;
    }

}
