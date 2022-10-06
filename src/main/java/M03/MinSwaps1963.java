package M03;

//1963. 使字符串平衡的最⼩交换次数
public class MinSwaps1963 {
    public int minSwaps(String s    ) {
        int n = s.length();
        int l_cnt=0,r_cnt=0,l=0,r=n-1,ans=0;
        l_cnt += (s.charAt(l)=='['?1:-1);
        r_cnt += (s.charAt(r)==']'?1:-1);

        while (l < r) {
            while (l_cnt >= 0 && l < r) {
                l++;
                l_cnt += (s.charAt(l)=='['?1:-1);
            }
            while (r_cnt >= 0 && l < r) {
                r--;
                r_cnt += (s.charAt(r)==']'?1:-1);
            }
            if (l>=r    ) break;
            ans+=1;
            l_cnt+=2;
            r_cnt+=2;
        }
        return ans;
    }
}
