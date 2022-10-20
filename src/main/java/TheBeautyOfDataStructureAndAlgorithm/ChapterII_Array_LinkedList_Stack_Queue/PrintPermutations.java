package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//递归实现全排列
public class PrintPermutations {
    public void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.println(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; i++) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
            printPermutations(data, n, k - 1);
            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }
}
