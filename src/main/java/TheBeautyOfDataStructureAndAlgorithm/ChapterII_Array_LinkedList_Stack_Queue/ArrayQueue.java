package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

/**
 * 基于数组
 */
public class ArrayQueue {
    private String[ ] items;
    private int n = 0;
    private int head = 0;   //队头下标
    private int tail = 0;   //队尾下标
    
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    
    public boolean enqueue(String item) {
        if (tail == n) return false; //tail == n 表示队列已满
        items[tail] = item;
        ++tail;
        return true;
    }
    
    public String dequeue() {
        if (head==tail) return null;    //head==tail 表示队列为空
        String ret = items[head];
        ++head;
        return ret;
    }
}
