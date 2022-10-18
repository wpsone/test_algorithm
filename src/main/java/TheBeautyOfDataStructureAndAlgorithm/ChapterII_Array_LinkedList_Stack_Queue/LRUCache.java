package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

import java.util.HashMap;
import java.util.Map;

//LRU缓存淘汰算法
public class LRUCache {
    private class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode(-1, -1);//"哨兵"节点
        this.tail = new DLinkedNode(-1, -1);//"哨兵"节点
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNodeAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            return;
        }
        if (size == capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        addNodeAtHead(newNode);
        cache.put(key, newNode);
        size++;
    }

    public void remove(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            removeNode(node);
            cache.remove(key);
            return;
        }
    }

    public void addNodeAtHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}
