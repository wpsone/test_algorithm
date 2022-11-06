package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//前缀和逻辑
public class PrefixSum {
    int[] a;
    int[] c;
    int n;
    public PrefixSum() {
    }

    public PrefixSum(int[] c) {
        this.c = c;
    }

    private int lowbit(int i) {
        return i&(-i);
    }
    
    public int sum(int i){
        int s = 0;
        while (i > 0) {
            s+=c[i];
            i-=lowbit(i);
        }
        return s;
    }
    
    public void update(int i,int delta){
        n=c.length;
        while (i<=n){
            c[i]+=delta;
            i+=lowbit(i);
        }
    }
    
    public void initC(){
        for (int i = 0; i < n; i++) {
            update(i,a[i]);
        }
    }
}
