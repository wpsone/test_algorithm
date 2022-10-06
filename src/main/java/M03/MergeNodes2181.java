package M03;

//2181. 合并零之间的节点
public class MergeNodes2181 {
    public ListNode mergeNodes(ListNode head) {
        if (head.next == null) return null;
        ListNode p = head;
        while (p.next.val != 0) {
            p.val += p.next.val;
            p.next = p.next.next;
        }
        p.next = mergeNodes(p.next);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val){
        this.val = val;
    }
    
    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}