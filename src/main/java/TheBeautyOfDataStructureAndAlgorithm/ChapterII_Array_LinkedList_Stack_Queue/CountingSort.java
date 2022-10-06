package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//计数排序
public class CountingSort {
    public void countingSort(int[] a,int n) {
        if (n<=1    ) return;
        //查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max<a[i]) {
                max = a[i];
            }
        }
        
        int[] c = new int[max+1];//申请一个计数数组c，下标范围是[0,max]
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }
        //计算每个元素的个数，放入数组c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }
        //依次累加
        for (int i = 1; i <= max; i++) {
            c[i]=c[i-1]+c[i];
        }
        //临时数组r，存储排序之后的结果
        int[] r = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }
        //将结果赋值给数组a
        for (int i = 0; i < n; i++) {
            a[i]=r[i];
        }
    }
}
