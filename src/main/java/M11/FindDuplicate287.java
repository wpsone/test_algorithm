package M11;

//287. 寻找重复数
public class FindDuplicate287 {
    public int findDuplicate(int[] nums) {
        int p = 0,q = 0;
        do {
            p = nums[p];
            q = nums[nums[q]];
        } while (p!=q);
        q=0;
        while (p!=q) {
            p=nums[p];
            q=nums[q];
        }
        return q;
    }
}
