package M09;

//696. 计数二进制子串
public class CountBinarySubstrings696 {
    public int countBinarySubstrings(String s) {
        int pre = 0,cur = 1,res = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre>=cur) res++;
        }
        return res;
    }
}
