package M09;

//459. 重复的子字符串
public class RepeatedSubstringPattern459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0]=-1;
        for (int i = 1,j=-1; i < n; i++) {
            while (j != -1 && s.charAt(i) != s.charAt(j + 1)) {
                j=next[j];
            }
            if (s.charAt(i)==s.charAt(j+1)) j+=1;
            next[i]=j;
        }
        if (next[n-1]!=-1 && n%(n-next[n-1]-1)==0) return true;
        return false;
    }
}
