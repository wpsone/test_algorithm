package M09;

//409. 最长回文串
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int[] ch = new int[128];
        for (char c : s.toCharArray()) {
            ch[c]++;
        }
        int ans = 0;
        for (int x : ch) {
            if (x==0) continue;
            ans += x % 2 == 0 ? x:x-1;
        }
        return ans==s.length()?ans:ans+1;
    }
}
