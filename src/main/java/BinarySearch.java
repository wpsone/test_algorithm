
//1) 二分查找
//二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列，注意必须要是有序排列。
public class BinarySearch {

    /**
     * 使用递归的二分查找
     * @param arr   有序数组
     * @param key   待查找关键字
     * @param low
     * @param high
     * @return  找到的位置
     */
    public static int recursionBinarySearch(int[] arr,int key,int low,int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low+high)/2;
        if (arr[middle]>key){
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr,key,low,middle-1);
        } else if (arr[middle]<key) {
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr,key,middle+1,high);
        } else {
            return middle;
        }
    }

    /**
     * 不使用递归的二分查找
     * @param arr
     * @param key
     * @return 关键字位置
     */
    public static int commonBinarySearch(int[] arr,int key) {
        int low = 0;
        int high = arr.length-1;
        int middle = 0;

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low+high)/2;
            if (arr[middle]>key) {
                //比关键字大则关键字在左区域
                high=middle-1;
            } else if (arr[middle]<key){
                //比关键字小则关键字在右区域
                low=middle+1;
            } else {
                return middle;
            }
        }
        return -1;//最后仍然没有找到，则返回-1
    }
}
