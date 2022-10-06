package M08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0]=true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j,i)) && dp[j]) {
                    dp[i]=true;
                }
            }
        }
        return dp[n];
    }
}
