package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//基于链表实现的并查集
public class LinkedUnionFindSet {
    private Node nodes[];

    public LinkedUnionFindSet(int n) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }

    public void union(int i, int j) {
        boolean inSameSet = find(i, j);
        if (inSameSet) {
            return;
        }
        Node li = nodes[i].R;
        Node lj = nodes[j].R;
        Node liTail = li.prev;
        Node ljTail = lj.prev;
        liTail.next = lj;
        lj.prev = liTail;
        ljTail.next = li;
        li.prev = ljTail;
        Node p = lj;
        while (p != ljTail) {
            p.R = li.R;
        }
        ljTail.R = li.R;
    }

    public boolean find(int i, int j) {
        return nodes[i].R == nodes[j].R;
    }

    public class Node {
        public Node prev = this;
        public Node next = this;
        public Node R = this;
    }
}
