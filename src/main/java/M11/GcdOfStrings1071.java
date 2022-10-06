package M11;

//1071. 字符串的最⼤公因⼦
public class GcdOfStrings1071 {
    public String gcdOfStrings(String str1,String str2) {
        if (!new StringBuffer().append(str1).append(str2).toString()
        .equals(new StringBuffer().append(str2).append(str1).toString())) return "";
        int n = gcd(str1.length(),str2.length());
        return str2.substring(0,n);
    }

    public int gcd(int a,int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
