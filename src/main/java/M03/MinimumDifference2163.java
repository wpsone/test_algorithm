package M03;

import java.util.PriorityQueue;

//2163. 删除元素后和的最⼩差值
public class MinimumDifference2163 {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m/3;
        long ans = Long.MAX_VALUE;
        PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long[] lsum = new long[m];
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += nums[i   ];
            left.offer(nums[i]);
            if (left.size()<n) continue;
            if (left.size()>n) {
                sum -= left.poll();
            }
            lsum[i] = sum;
        }
        sum = 0;
        for (int i = m-1; i >= n; i--) {
            sum += nums[i   ];
            right.offer(nums[i  ]);
            if (right.size()<n) continue;
            if (right.size()>n) {
                sum -= right.poll();
            }
            ans = Math.min(ans,lsum[i-1]-sum);
        }
        return ans;
    }
}
