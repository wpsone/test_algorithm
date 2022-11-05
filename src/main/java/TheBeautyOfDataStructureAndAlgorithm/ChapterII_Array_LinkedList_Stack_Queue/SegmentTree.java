package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

//基于线段树的定义和存储方式，创建一个最大值为m的空线段树
public class SegmentTree {
    private int m;
    private Segment segments[    ];
    
    public SegmentTree(int m) {//构建空的线段树
        this.m=m;
        segments=new Segment[4*m];
        buildSegmentTreeInternal(1,m,1);
    }
    
    private void buildSegmentTreeInternal(int left,int right,int i) {
        segments[i]=new Segment();
        segments[i].left=left;
        segments[i].right=right;
        segments[i].count=0;
        if (left==right) return;
        int mid=(left+right)/2;
        buildSegmentTreeInternal(left,mid,i*2);
        buildSegmentTreeInternal(mid+1,right,i*2+1);
    }
    
    //向集合中插入时对应的线段树的更新操作
    public void insert(int data ){
        int left = 1;
        int right = m;
        int i=1;
        while (left != right) {
            segments[i].count++;
            int mid = (left+right   )/2;
            if (data <= mid) {
                right=mid;
                i=i*2;
            } else {
                left=mid+1;
                i=i*2+1;
            }
        }
        segments[i].count++;
    }
    
    public void delete(int data ) {
        int left=1;
        int right=m;
        int i=1;
        while (left != right) {
            segments[i].count--;
            int mid = (left+right)/2;
            if (data <= mid) {
                right=mid;
                i=i*2;
            } else {
                left=mid+1;
                i=i*2+1;
            }
        }
        segments[i].count--;
    }
    
    public int count(int left,int right){
        return countInternal(left,right,1);
    }
    
    private int countInternal(int left,int right,int i){
        if (segments[i].left == left && segments[i].right == right) {
            return segments[i].count;
        }
        int mid = (segments[i].left+segments[i].right)/2;
        if (left > mid) {
            return countInternal(left,right,i*2+1);
        } else if (right <= mid) {
            return countInternal(left,mid,i*2);
        } else {
            return countInternal(left,mid,i*2   )+countInternal(mid+1,right,i*2+1);
        }
    }
    
    //查询区间第K大值
    public int getKth(int left,int right,int k){
        return getKthInternal(left,right,1,k);
    }
    private int getKthInternal(int left,int right,int i,int k){
        if (segments[i].left == left && segments[i].right == right) {
            if (k != -1) {
                return -1;//表示第k大值存在
            } else {
                return segments[i].left;
            }
        }
        int mid = (left+right   )/2;
        int rightSegmentCount=countInternal(mid+1,right,i*2+1);
        if (rightSegmentCount >= k) {
            return getKthInternal(mid+1,right,i*2+1,k);
        }else {
            return getKthInternal(left,mid,i*2,k-rightSegmentCount);
        }
    }
    
    
    public void deleteKth(int data){
        deleteInternal(data,1);
    }
    
    private void deleteInternal(int data,int i){
        if (segments[i].left == segments[i].right) {
            segments[i].max = Integer.MIN_VALUE;
            return;
        }
        int mid=(segments[i].left+segments[i].right)/2;
        if (data <= mid) {
            deleteInternal(data,i*2);
        } else {
            deleteInternal(data,i*2+1);
        }
        segments[i].max=Math.max(segments[i*2].max,segments[i*2+1].max);
    }
    
    public class Segment{
        public int left;//区间起始点
        public int right;//区间结束点
        public int count;//统计值
        public int max;
    }
}
