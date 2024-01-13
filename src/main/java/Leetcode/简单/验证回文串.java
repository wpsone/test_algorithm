package Leetcode.简单;

import java.util.Locale;

public class 验证回文串 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase(Locale.ROOT).toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; ) {
            if (i < j && Character.isLetterOrDigit(chars[i])
                    && Character.isLetterOrDigit(chars[j])) {
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                    if (i > j) {
                        return true;
                    }
                    continue;
                } else {
                    return false;
                }
            }
            if (i < j && Character.isLetterOrDigit(chars[i])
                    && !Character.isLetterOrDigit(chars[j])) {
                j--;
                continue;
            }
            if (i < j && !Character.isLetterOrDigit(chars[i])
                    && Character.isLetterOrDigit(chars[j])) {
                i++;
                continue;
            }
            if (i < j && !Character.isLetterOrDigit(chars[i])
                    && !Character.isLetterOrDigit(chars[j])) {
                i++;
                j--;
                if (i > j) {
                    return true;
                }
                continue;
            }
            if (i == j && chars[i] == chars[j]) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public boolean isPalindrome4(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public boolean isPalindrome5(String s) {
        int left = 0, right = s.length() - 1;
        int li = -1, ri = -1;
        while (left < right) {
            while (left <= right && (li = getInt(s.charAt(left))) == -1) {
                left++;
            }
            while (left <= right && (ri = getInt(s.charAt(right))) == -1) {
                right--;
            }
            if (right > left && li != ri) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private int getInt(char cha) {
        if ((cha >= 65 && cha <= 90) || (cha >= 48 && cha <= 57)) {
            return cha;
        }
        if (cha >= 97 && cha <= 122) {
            return cha - 32;
        }
        return -1;
    }


    public boolean isPalindrome6(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isValidate(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValidate(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValidate(char target) {
        return (target >= 'a' && target <= 'z')
                || (target >= '0' && target <= '9');
    }


    public static void main(String[] args) {
        验证回文串 test = new 验证回文串();
        boolean tf = test.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(tf);
    }
}
