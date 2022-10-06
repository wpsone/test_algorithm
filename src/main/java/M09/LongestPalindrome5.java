package M09;

//5. 最长回文子串
public class LongestPalindrome5 {
    public String getNewString(String s) {
        String ns="#";
        for (char c : s.toCharArray()) {
            ns+= c +"#";
        }
        return ns;
    }

    public String longestPalindrome(String s) {
        String s1 = getNewString(s);
        int n = s1.length();
        int[] d = new int[n];
        int l=0,r=-1;
        for (int i = 0; i < n; i++) {
            if (i > r) {
                d[i]=1;
            } else {
                d[i]=Math.min(r-i,d[r-i+l]);
            }
            while (i - d[i] >= 0 && i + d[i] < n
                    && s1.charAt(i - d[i]) == s1.charAt(i + d[i])) {
                d[i]++;
            }
            if (i - d[i] >= 0 && i + d[i] > r) {
                l=i-d[i];
                r=i+d[i];
            }
        }
        StringBuffer ret = new StringBuffer();
        int temp=-1;
        for (int i = 0; i < n; i++) {
            if (d[i]<temp) continue;
            temp=d[i];
            ret=new StringBuffer();
            for (int j = i-d[i]+1; j < i + d[i]; j++) {
                if (s1.charAt(j)=='#') continue;
                ret.append(s1.charAt(j));
            }
        }
        return ret.toString();
    }
}
