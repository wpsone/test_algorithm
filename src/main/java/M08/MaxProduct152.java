package M08;

//152. 乘积最⼤⼦数组
public class MaxProduct152 {

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE,max_num=1,min_num=1;
        for (int num : nums) {
            if (num < 0) {
                int t = max_num;
                max_num=min_num;
                min_num=t;
            }
            max_num=Math.max(max_num*num,num);
            min_num=Math.min(min_num*num,num);
            ans=Math.max(ans,max_num);
        }
        return ans;
    }

}
