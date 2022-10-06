package M12;

//剑指 Offer II 029. 排序的循环链表
public class Insert_OfferII029 {

    public Node insert(Node head,int insertVal) {
        Node p = head;
        Node max = head;

        while (p!=null) {
            if (p.val > p.next.val) max = p;
            if (p.val <= insertVal && p.next.val >= insertVal) break;
            if (head == p.next) {
                p = max;
                break;
            }
            p = p.next;
        }

        Node node = new Node(insertVal);
        if (p != null) {
            node.next = p.next;
            p.next = node;
        } else {
            head = node;
            head.next = head;
        }
        return head;
    }
}

class Node {
    int val;
    Node next;

    Node() {}

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    Node(int val,Node next) {
        this.val = val;
        this.next = next;
    }
}
