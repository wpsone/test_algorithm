package M09;

import java.util.Arrays;

//经典匹配算法：KMP、
//        Sunday 与 Shift-[AndOr] 算法
public class StringMatching {

    public static int shift_and(String text,String pattern) {
        long[] code = new long[256];
        int n;
        for (n = 0; n < pattern.length(); n++) {
            code[pattern.charAt(n)]|=(1<<n);
        }
        long p = 0;
        for (int i = 0; i < text.length(); i++) {
            p=((p<<1)|1) & code[text.charAt(i)];
            if ((p&(1<<(n-1)))!=0) return i-n+1;
        }
        return -1;
    }

    private static int sunday(String text,String pattern) {
        int[] last_pos = new int[256];
        Arrays.fill(last_pos,-1);
        int n=text.length(),m=pattern.length();
        for (int i = 0; i < pattern.length(); i++) {
            last_pos[pattern.charAt(i)]=i;
        }
        for (int i = 0; i +m<=n ; i+=(m - last_pos[text.charAt(i + m)])) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (pattern.charAt(j)==text.charAt(i+j)) continue;
                flag=false;
                break;
            }
            if (flag) return i;
            if (n<=m+i) break;
        }
        return -1;
    }

    private static int Kmp(String text,String pattern) {
        int n=text.length(),m=pattern.length();
        int[] next = new int[m];
        getnext(pattern,next);
        for (int i = 0,j=-1; i < n; i++) {
            while (j!=-1 && text.charAt(i)!=pattern.charAt(j+1)) j=next[j];
            if (text.charAt(i)==pattern.charAt(j+1)) j+=1;
            if (j+1==pattern.length()) return i-j;
        }
        return -1;
    }

    private static void getnext(String pattern,int[] next) {
        next[0]=-1;
        for (int i = 1,j=-1; i < pattern.length(); i++) {
            while (j!=-1 && pattern.charAt(i)!=pattern.charAt(j+1)) j=next[j];
            if (pattern.charAt(i)==pattern.charAt(j+1)) j+=1;
            next[i]=j;
        }
    }
}
