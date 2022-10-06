package M11;

public class AddBinary67 {
    public String addBinary(String a,String b) {
        if (a.equals("0") && b.equals("0")) return "0";
        int len_a = a.length();
        int len_b = b.length();
        int n_len = len_a>len_b ? len_a:len_b;
        int[] str = new int[n_len+1];
        int k = 0;
        for (int i = len_a-1,j=len_b-1,n=n_len; i >= 0 || j>= 0; i--,j--,n--) {
            int a_val = i < 0 ? 0 : a.charAt(i) - '0';
            int b_val = j < 0 ? 0 : b.charAt(j) - '0';
            str[n] = a_val ^ b_val ^ k;
            if (a_val+b_val+k>=2) k=1;
            else k=0;
        }
        if (k!=0) str[0]=1;
        StringBuffer stringBuffer = new StringBuffer();
        boolean flag = true;
        for (int x : str) {
            if (x==0 && flag) continue;
            flag = false;
            stringBuffer.append(x);
        }
        return stringBuffer.toString();
    }
}
