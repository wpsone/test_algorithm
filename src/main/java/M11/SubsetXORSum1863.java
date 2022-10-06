package M11;

//1863. 找出所有⼦集的异或总和再求和
public class SubsetXORSum1863 {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            dfs(i+1,nums[i],nums);
        }
        return result;
    }

    public void dfs(int temp,int sum,int[] nums) {
        if (temp == nums.length) result += sum;
        else {
            dfs(temp+1,sum,nums);
            dfs(temp+1,sum^nums[temp    ],nums);
        }
    }
}
