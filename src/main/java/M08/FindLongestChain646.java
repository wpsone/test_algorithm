package M08;

import java.util.Arrays;
import java.util.Comparator;

//646. 最⻓数对链
public class FindLongestChain646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (pairs[i][0]>pairs[j][1]) {
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                } else {
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
        }
        return dp[n-1];
    }
}
