package M10;

//1829. 每个查询的最⼤异或值
public class GetMaximumXor1829 {
    public int[] getMaximumXor(int[] nums,int maximumBit) {
        int max = (int) Math.pow(2,maximumBit) - 1;
        int temp = 0;
        int[] ans = new int[nums.length];
        for (int i = 0,j=nums.length-1; i < nums.length; i++,j--) {
            temp ^= nums[i];
            ans[j]=temp^max;
        }
        return ans;
    }
}
