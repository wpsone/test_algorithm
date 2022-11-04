package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//基于树的并查集
public class TreeUnionFindSet {
    private int p[];
    private int rank[];

    public TreeUnionFindSet(int n) {
        p = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            rank[i] = 1;
        }


    }

    public void union(int i, int j) {
        if (find(i, j)) {
            return;
        }
        if (rank[i] > rank[j]) {
            p[j] = i;
        } else if (rank[i] < rank[j]) {
            p[j] = j;
        } else {
            p[i] = j;
            rank[j]++;
        }
    }

    public boolean find(int i, int j) {
        return findR(i) == findR(j);
    }

    public int findR(int i) {//路径压缩
        if (p[i] != i) {
            p[i] = findR(p[i]);
        }
        return p[i];
    }
}
