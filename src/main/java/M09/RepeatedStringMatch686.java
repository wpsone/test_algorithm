package M09;

//686. 重复叠加字符串匹配
public class RepeatedStringMatch686 {
    public int repeatedStringMatch(String a,String b) {
        int len_a = a.length();
        int len_b = b.length();

        int cnt = 1;
        StringBuffer temp = new StringBuffer(a);
        while (temp.length() < len_a * 2 + len_b) {
            if (temp.indexOf(b)!=-1) return cnt;
            temp.append(a);
            cnt++;
        }
        return -1;
    }
}
