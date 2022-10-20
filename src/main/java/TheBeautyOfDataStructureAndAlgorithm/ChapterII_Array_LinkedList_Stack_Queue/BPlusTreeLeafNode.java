package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

/**
 * B+树种叶子节点的定义
 * <p>
 * B+树种的叶子节点与内部节点是不一样的
 * 叶子节点存储是值，而非区间
 * 在这个定义里，每个叶子节点存储3个数据行的键值及地址信息
 * <p>
 * k值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小
 * PAGE_SIZE=k*4[keywors的大小]+k*8[dataAddress的大小]+8[prev的大小]+8[next的大小]
 */
public class BPlusTreeLeafNode {
    public static int k = 3;
    public int[] keywors = new int[k];//数据的键值
    public long[] dataAddress = new long[k];//数据地址
    public BPlusTreeLeafNode prev;//有序链表的前驱节点指针
    public BPlusTreeLeafNode next;//有序链表的后继节点指针
}
