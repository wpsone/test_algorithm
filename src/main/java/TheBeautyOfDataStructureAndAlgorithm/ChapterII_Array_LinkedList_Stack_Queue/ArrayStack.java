package TheBeautyOfDataStructureAndAlgorithm.ChapterII_Array_LinkedList_Stack_Queue;

/**
 * 基于数组实现的顺序栈 page36
 */
public class ArrayStack {
    private String[] items;//数组
    private int count; //栈中元素的个数
    private int n;  //栈的大小
    
    public ArrayStack(int n  ) {
        this.items = new String[n   ];  //申请一个大小为n的数组空间
        this.count = 0;
        this.n = n;
    }
    
    public boolean push(String item ) {
        if (count == n) return false;   //数组空间不够了，入栈失败
        //将item放到下标为count-1的数组元素，并且栈中元素的个数count减1
        String tmp = items[count - 1];
        ++count;
        return true;
    }
    
    public String pop( ) {
        if (count == 0) return null;    //若栈为空，则直接返回null
        //返回下标为count-1的数组元素，并且栈中元素的个数count减1
        String tmp = items[count - 1];
        --count;
        return tmp;
    }
}
