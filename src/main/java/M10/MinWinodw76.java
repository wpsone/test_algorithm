package M10;

//76. 最⼩覆盖⼦串
public class MinWinodw76 {
    public String minWindow(String s,String t) {
        int[] alp = new int[128];
        int cnt = 0;
        for (char c : t.toCharArray()) {
            alp[c]--;
            if (alp[c]==-1) cnt++;
        }
        int l=0,r=0,len=s.length()+1;
        String res="";
        while (r<=s.length()) {
            if (cnt != 0) {
                if (r==s.length()) break;
                int c=s.charAt(r);
                if (++alp[c]==0) cnt--;
                r+=1;
            } else {
                int c = s.charAt(l);
                if (--alp[c]==-1) cnt++;
                l++;
            }
            if (cnt==0 && r-l <len) {
                res = s.substring(l,r);
                len=r-l;
            }
        }
        return res;
    }
}
