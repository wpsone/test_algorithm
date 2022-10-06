package M08;

//504. 七进制数
public class ConvertToBase7_504 {
    public String convertToBase7(int num) {
        if (num==0) return "0";
        String s="";
        int flag=1;
        if (num<0) flag=-1;
        while (num!=0) {
            int a= Math.abs(num%7);
            s=a+s;
            num/=7;
        }
        if (flag<0) s="-"+s;
        return s;
    }
}
