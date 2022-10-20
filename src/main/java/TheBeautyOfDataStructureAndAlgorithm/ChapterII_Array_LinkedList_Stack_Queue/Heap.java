package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;


public class Heap {
    private int[] a;//数组，从下标1开始存储数据
    private int n;//堆可以存储的最大的数据个数
    private int count;//堆种已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) return;//堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {//自下而上堆化
            swap(a, i, i / 2);//swap()函数的作用：交换下标为i和i/2的两个元素
        }
    }

    public void removeMax() {
        if (count == 0) return;//堆中没有数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int count, int i) {//自上而下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
