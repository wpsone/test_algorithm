package M11;

import java.util.Arrays;
import java.util.PriorityQueue;

//LCP 30. 魔塔游戏
public class MagicTower_LCP30 {
    public int magicTower(int[] nums) {
        if (Arrays.stream(nums).sum()<0) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        long HP = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i]<0) {
                pq.offer(nums[i]);
                if (HP + nums[i] <= 0) {
                    HP-=pq.poll();
                    cnt+=1;
                }
            }
            HP+=nums[i];
        }
        return cnt;
    }
}
