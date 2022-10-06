package M11;

//1512. 好数对的数⽬
public class NumIdenticalPairs1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        int ans = 0;
        for (int x : nums) {
            ans += cnt[x];
            cnt[x]++;
        }
        return ans;
    }
}
