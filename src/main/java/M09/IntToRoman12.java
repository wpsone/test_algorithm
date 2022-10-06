package M09;

//12. 整数转罗马数字
public class IntToRoman12 {

    public String getRoman(int num,String a,String b,String c ){
        if (num==4||num==9) {
            return num==4?a+b:a+c;
        }
        String ret = "";
        if (num >= 5) {
            ret+=b;
            num-=5;
        }
        while (num-- > 0) {
            ret+=a;
        }
        return ret;
    }

    public String intToRoman(int num) {
        String ret = "";
        while (num != 0) {
            if (num >= 1000) {
                int d=num/1000;
                num%=1000;
                ret+=getRoman(d,"M","M","M");
            } else if (num >= 100) {
                int d=num/100;
                num%=100;
                ret+=getRoman(d,"C","D","M");
            } else if (num >= 10) {
                int d=num/10;
                num%=10;
                ret+=getRoman(d,"X","L","C");
            } else {
                int d=num;
                num=0;
                ret+=getRoman(d,"I","V","X");
            }
        }
        return ret;
    }
}
