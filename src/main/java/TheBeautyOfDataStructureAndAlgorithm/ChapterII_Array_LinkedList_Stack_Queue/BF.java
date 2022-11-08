package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//BF(Brute Force，暴力匹配)算法也称朴素匹配算法
public class BF {
    //返回第一个匹配的起始下标位置
    int bf(char a[], int n, char b[], int m) {
        for (int i = 0; i < n - m; i++) {
            int j = 0;
            while (j < m) {
                if (a[i + j] != b[j]) {
                    break;
                }
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
