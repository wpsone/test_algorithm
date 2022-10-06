package M07;

//41. 缺失的第⼀个正数
public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i]<=0||nums[i]>nums.length) break;
                int ind = nums[i]-1;
                if (nums[ind]==nums[i       ]) break;
                swap(nums,i,ind);
            }
        }
        int ind = 0;
        while (ind<nums.length && nums[ind]==ind+1) ind++;
        return ind+1;
    }

    private void swap(int[] arr,int i,int j) {
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
