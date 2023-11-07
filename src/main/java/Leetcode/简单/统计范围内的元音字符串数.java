package Leetcode.简单;

public class 统计范围内的元音字符串数 {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            char first = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if ((first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') &&
                    (end == 'a' || end == 'e' || end == 'i' || end == 'o' || end == 'u')) {
                count++;
            }
        }
        return count;
    }
}
