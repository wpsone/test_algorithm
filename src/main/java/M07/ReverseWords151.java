package M07;

//151. 翻转字符串⾥的单词
public class ReverseWords151 {
    public String reverseWords(String s) {
        String[] str = s.split(" +");
        int l=0,r=str.length-1,flag=0;
        if (s.charAt(0)==' ') flag=-1;
        while (l < r) {
            String temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < str.length + flag; i++) {
            if (i!=0) ret.append(" ");
            ret.append(str[i]);
        }
        return ret.toString();
    }
}
