package M10;

import java.util.PriorityQueue;

//1167. 连接棒材的最低费⽤
public class ConnectSticks1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.offer(stick);
        }
        int ans = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            a+=queue.poll();
            queue.offer(a);
            ans+=a;
        }
        return ans;
    }
}
