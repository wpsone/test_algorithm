/**
 * 二分查找 时间复杂度O(log2n);空间复杂度O(1)
 * 前提有序数组
 */
public class BinarySearch1 {

    public static void main(String[] args) {
        int[] data = {1,8, 10, 89, 1000, 1000,1234};//需要排序
        int result = binarySearch(data, 0, data.length - 1, 89);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr,int left,int right,int findVal) {
        if (left>right) return -1;
        int midIndex = (left + right)/2;

        if (findVal < arr[midIndex]) {
            //向左递归查找
            midIndex = binarySearch(arr, left, midIndex, findVal);
        } else if (findVal > arr[midIndex] ) {
            //向右递归查找
            midIndex = binarySearch(arr,midIndex,right,findVal);
        }
        //查找到，返回下标
        return midIndex;
    }
}
