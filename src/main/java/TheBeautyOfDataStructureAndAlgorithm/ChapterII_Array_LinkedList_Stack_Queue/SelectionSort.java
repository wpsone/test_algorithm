package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

public class SelectionSort {
    public void selectionSort(int[] a,int n) {
        if (n<=1) return;
        for (int i = 0; i < n - 1; i++) {//循环n-1次就可以
            int minPos = i;
            for (int j = i; j < n; j++) {//查找min
                if (a[j]<a[minPos]) {
                    minPos = j;
                }
            }
            //交换元素
            int tmp = a[i];
            a[i] = a[minPos];
            a[minPos] = tmp;
        }
    }
}
