package M07;

import M07.Utils.*;

//876. 链表的中间结点
public class MiddleNode876 {
    public ListNode middleNode(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            pre=pre.next;
            cur=cur.next.next;
        }
        return pre;
    }
}
