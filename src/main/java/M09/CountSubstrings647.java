package M09;

//647. 回文子串
public class CountSubstrings647 {
    public int countSubstrings(String s) {
        String s1 = getNewStr(s);
        int n = s1.length();
        int[] d = new int[n];
        int l = 0,r=-1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i>r) d[i]=1;
            else d[i]=Math.min(r-i,d[r-i+1]);
            while (i-d[i]>=0 && i+d[i]<n && s1.charAt(i-d[i])==s1.charAt(i+d[i])) {
                d[i]++;
            }
            if (i-d[i]>=0 && i+d[i]>r) {
                l = i - d[i];
                r = i + d[i];
            }
            cnt+=d[i]/2;
        }
        return cnt;
    }

    public String getNewStr(String s) {
        StringBuffer newStr = new StringBuffer("#");
        for (char c : s.toCharArray()) {
            newStr.append(c+"#");
        }
        return newStr.toString();
    }
}
