package M11;

import java.util.ArrayList;
import java.util.List;

//132. 分割回⽂串 II
public class MinCut132 {

    public void extract(String s, int i, int j, List<List<Integer>> mark) {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            mark.get(j+1).add(i);
            i--;
            j++;
        }
    }

    public int minCut(String s) {
        List<List<Integer>> mark = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            mark.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            extract(s,i,i,mark);
            extract(s,i,i+1,mark);
        }
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i]=i;
            for (Integer j : mark.get(i)) {
                dp[i] = Math.min(dp[j]+1,dp[i]);
            }
        }
        return dp[s.length()]-1;
    }
}
