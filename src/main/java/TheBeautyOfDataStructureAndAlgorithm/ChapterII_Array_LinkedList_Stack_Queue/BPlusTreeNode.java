package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

/**
 * B+树非叶子节点的定义
 * <p>
 * 假设keywords=[3,5,8,10]
 * 4个键值将数据分为5个区间：(-INF,3),[3,5),[5,8),[8,10),[10,INF)
 * 5个区间分别对应：children[0]...children[4]
 * <p>
 * m值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小
 * PAGE_SIZE = (m-1)*4[keywords的大小]+m*8[children的大小]
 */
public class BPlusTreeNode {
    public static int m = 5;//5叉树
    public int[] keywords = new int[m - 1];//键值，用来划分数据区间
    public BPlusTreeNode[] children = new BPlusTreeNode[m];//子节点
}
