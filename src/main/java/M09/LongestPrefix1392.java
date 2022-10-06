package M09;

//1392. 最⻓快乐前缀
public class LongestPrefix1392 {

    public String longestPrefix(String s) {
        int[] next = new int[s.length()];
        int n = s.length();
        getnext(next,s.toCharArray());
        if (next[n-1]==-1) return "";
        return s.substring(0,next[n-1]+1);
    }

    private void getnext(int[] next,char[] pattern) {
        next[0]=-1;
        int n = pattern.length;
        for (int i = 1,j=-1; i < n; i++) {
            while (j!=-1 && pattern[i]!=pattern[j+1]) j=next[j];
            if (pattern[i]==pattern[j+1]) j+=1;
            next[i]=j;
        }
    }
}
