package M10;

//468. 验证IP地址
public class ValidIPAddress468 {
    public String validIPAddress(String queryIP) {
        int pre = 0,flag = 0,cnt = 0;
        for (int i = 0; i <= queryIP.length(); i++) {
            if (flag == 4 && i==queryIP.length() || i<queryIP.length()&& queryIP.charAt(i)=='.') {
                if (flag==0) flag=4;
                if (flag!=4||!isIPv4(queryIP,pre,i)) return "Neither";
                pre=i+1;
                cnt++;
            }
            if (flag==6 && i==queryIP.length()||i<queryIP.length()&&queryIP.charAt(i)==':') {
                if (flag==0) flag=6;
                if (flag!=6||!isIPv6(queryIP,pre,i)) return "Neither";
                pre=i+1;
                cnt++;
            }
        }
        if (flag==4&&cnt==4) return "IPv4";
        if (flag==6&&cnt==8) return "IPv6";
        return "Neither";
    }

    boolean isIPv4(String ip,int l,int r) {
        if (l>=r || r-l>3) return false;
        if (r-l>1 && ip.charAt(l)=='0') return false;
        int num=0;
        for (int i = l; i < r; i++) {
            if (ip.charAt(i)<'0'||ip.charAt(i)>'9') return false;
            num=num*10+(ip.charAt(i)-'0');
        }
        return num<=255;
    }

    boolean isIPv6(String ip,int l,int r) {
        if (l>=r||r-l>4) return false;
        int num=0;
        for (int i = l; i < r; i++) {
            char c = ip.charAt(i);
            if (c<='9' && c>='0') continue;
            if (c<='f' && c>='a') continue;
            if (c<='F' && c>='A') continue;
            return false;
        }
        return true;
    }
}
