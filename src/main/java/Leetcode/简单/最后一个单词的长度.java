package Leetcode.简单;

public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
//        String[] strs = s.split(" ");
//        int len = 0;
//        for (String str : strs) {
//            if (str.length() > 0) {
//                len = str.length();
//            }
//        }
//        return len;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
