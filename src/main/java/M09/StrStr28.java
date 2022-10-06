package M09;

//28. 实现 strStr()
public class StrStr28 {
//    public int strStr(String haystack,String needle) {
//        if (needle.equals("")) return 0;
//        return KMP(haystack,needle);
//    }
//
//    public int KMP(String text,String pattern) {
//        int n=text.length(),m=pattern.length();
//        int[] next = new int[m];
//        getnext(pattern,next);
//        for (int i = 0,j=-1; i < text.length(); i++) {
//            while (j!=-1 && pattern.charAt(j+1)!=text.charAt(i)) j=next[j];
//            if (pattern.charAt(j+1)==text.charAt(i)) j+=1;
//            if (j+1==pattern.length()) return i-j;
//        }
//        return -1;
//    }
//
//    private void getnext(String pattern,int[] next ){
//        next[0]=-1;
//        for (int i = 1,j=-1; i < pattern.length(); i++) {
//            while (j!=-1 && pattern.charAt(j+1)!=pattern.charAt(i)) j=next[j];
//            if (pattern.charAt(j+1)==pattern.charAt(i)) j+=1;
//            next[i]=j;
//        }
//    }

    public int strStr(String haystack,String needle) {
        int m = needle.length();
        int n = haystack.length();
        int[] last_pos = new int[256];
        for (int i = 0; i < m; i++) {
            last_pos[needle.charAt(i)]=i;
        }
        for (int i = 0; i + m <= n; i+=(m-(last_pos[haystack.charAt(i+m)]))) {
            boolean flag=true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i+j)==needle.charAt(j)) continue;
                flag=false;
                break;
            }
            if (flag) return i;
            if (i+m>=n) break;
        }
        return -1;
    }
}
