package M09;

import java.lang.reflect.Array;
import java.util.Arrays;

//3. ⽆重复字符的最⻓⼦串
public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        int[] dp = new int[s.length()];
        int[] ch = new int[257];
        Arrays.fill(ch,-1);
        Arrays.fill(dp,1);
        ch[s.charAt(0)]=0;
        for (int i = 1; i < s.length(); i++) {
            if (ch[s.charAt(i)]==-1 || ch[s.charAt(i)]<i-dp[i-1]) {
                dp[i]=dp[i-1]+1;
            } else {
                dp[i]=i-ch[s.charAt(i)];
            }
            ch[s.charAt(i)]=i;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
