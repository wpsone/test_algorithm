package M09;

//面试题 01.05. 一次编辑
public class OneEditAway01_05 {
    public boolean oneEditAway(String first,String second) {
        int n = first.length();
        int m = second.length();
        if (Math.abs(n-m)>1) return false;
        if (n == m) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (first.charAt(i)==second.charAt(i)) continue;
                if (flag) flag=false;
                else return false;
            }
            return true;
        }
        if (n<m) {
            String temp = first;
            first=second;
            second=temp;
        }
        n=first.length();
        m=second.length();
        int i=0;
        while (i<m && first.charAt(i)==second.charAt(i)) i++;
        while (i<m && first.charAt(i+1)==second.charAt(i)) i++;
        return i==m;
    }
}
