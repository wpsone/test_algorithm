package M11;

//1147. 段式回⽂
public class LongestDecomposition1147 {
    public int getResult(String s,int l,int r) {
        int n = r - l + 1;
        int i,j;

        if (n<=1) return n;
        for (int k = 1; k <= n / 2; k++) {
            for (i = l,j=r-k+1; j <= r; i++,j++) {
                if (s.charAt(i)==s.charAt(j)) continue;
                break;
            }
            if (j==r+1) {
                return getResult(s,l+k,r-k)+2;
            }
        }
        return 1;
    }

    public int longestDecomposition(String text) {
        return getResult(text,0,text.length()-1);
    }
}
