package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

public class BubbleSort {
    void bubbleSort(int[] a,int n) {
        if (n<=1) return;
        for (int i = 0; i < n; i++) {
            boolean flag = false; //提前推出冒泡循环的标志位
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) { //交换相邻的两个元素
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;    //表示有数据交换
                }
            }
            if (!flag) break;   //没有数据交换提前退出
        }
    }
}
