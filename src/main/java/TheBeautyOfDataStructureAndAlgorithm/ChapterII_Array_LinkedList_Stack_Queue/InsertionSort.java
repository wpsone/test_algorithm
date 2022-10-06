package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

public class InsertionSort {
    public void insertionSort(int[] a,int n) {
        if (n<=1) return;
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {   //查找插入的位置
                if (a[j] > value) { 
                    a[j+1] = a[j]; //数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; //插入数据
        }
    }
}
