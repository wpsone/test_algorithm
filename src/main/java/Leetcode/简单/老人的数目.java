package Leetcode.简单;

public class 老人的数目 {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (int i = 0; i < details.length; i++) {
            String sub = details[i].substring(11, 13);
            if (Integer.parseInt(sub) > 60) {
                cnt++;
            }
        }
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        老人的数目 xxx = new 老人的数目();
        String[] details = new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        int i = xxx.countSeniors(details);
        System.out.println(i);
    }
}
