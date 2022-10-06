package M03;

import java.util.Arrays;

//2182. 构造限制重复的字符串
public class RepeatLimitedString2182 {
    public String repeatLimitedString(String s,int repeatLimit) {
        int n = s.length();
        Character[] str = new Character[n+5 ];
        Arrays.fill(str,'\0');
        for (int i = 0; i < n; i++) {
            str[i]=s.charAt(i);
        }
        Arrays.sort(str,(c1,c2)->c2-c1);
        StringBuffer temp;
        StringBuffer ans = new StringBuffer();
        int i = 0,j=0;
        while (i < n) {
            temp = new StringBuffer();
            temp.append(str[i   ]);
            i++;
            while (i < n && str[i] == temp.charAt(0)) {
                temp.append(str[i   ]);
                i++;
            }
            j=0;
            while (temp.length() - j > repeatLimit) {
                ans.append(temp.substring(j,j+repeatLimit));
                if (str[i]=='\0') return ans.toString();
                ans.append(str[i]);
                i++;
                j+=repeatLimit;
            }
            if (j < n) {
                ans.append(temp.substring(j,Math.min(j+repeatLimit,temp.length())));
            }
        }
        return ans.toString();
    }
}
