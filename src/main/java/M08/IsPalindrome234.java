package M08;

import M08.Utils.*;

//234. 回⽂链表
public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        int h1=0,h2=0,t=1;
        while (head != null) {
            h1 = h1 * 10 + head.val;
            h2 = h2 + t * head.val;
            t*=10;
            head=head.next;
        }
        return h1==h2;
    }
}
