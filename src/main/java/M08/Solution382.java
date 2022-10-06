package M08;

import M08.Utils.*;

import java.util.Random;

public class Solution382 {
    ListNode head;

    public Solution382(ListNode head) {
        this.head=head;
    }

    public int getRandom() {
        Random random = new Random();
        int ans = head.val;
        ListNode node = head.next;
        for (int i = 1; node != null; i++,node=node.next) {
            int d = random.nextInt(i + 1);
            if (d < 1) {
                ans=node.val;
            }
        }
        return ans;
    }
}
