package M07;

import java.util.*;

//47. 全排列 II
public class PermuteUnique47 {
    List<List<Integer>> res;
    Deque<Integer> path;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums.length==0) return res;
        int len = nums.length;
        Arrays.sort(nums);
        path = new ArrayDeque<>();
        used = new boolean[len];
        dfs(nums,len,0);
        return res;
    }

    private void dfs(int[] nums,int len,int depth) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1);
            used[i]=false;
            path.removeLast();
        }
    }
}
