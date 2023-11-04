package Leetcode.简单;

public class 统计能整除数字的位数 {
    public int countDigits(int num) {
        int count = 0;
        String str = String.valueOf(num);
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            int ii = Integer.parseInt(String.valueOf(str.charAt(i)));
            System.out.println(ii);
            if (num % ii == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        统计能整除数字的位数 xxx = new 统计能整除数字的位数();
        int i = xxx.countDigits(7);
        System.out.println(i);
    }
}
