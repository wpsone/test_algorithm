package M09;

public class ShortestPalindrome214 {
    public String shortestPalindrome(String s) {
        String s1 = new StringBuffer(s).reverse().toString();
        s1=s+"#"+s1;
        int n = s1.length();
        int[] next = new int[n];
        next[0]=-1;
        for (int i = 1,j=-1; i < n; i++) {
            while (j!=-1 && s1.charAt(i)!=s1.charAt(j+1))
                j=next[j];
            if (s1.charAt(i)==s1.charAt(j+1)) j++;
            next[i]=j;
        }
        s=new StringBuffer(s.substring(next[n-1]+1)).reverse().append(s).toString();
        return s;
    }
}
