import java.util.ArrayList;
import java.util.List;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] data = {1,8, 10, 89, 1000, 1000,1234};//需要排序
        List<Integer> list = new ArrayList<>();
        list = binarySearch(data, 0, data.length - 1, 89,list);
        System.out.println(list);
    }

    public static List<Integer> binarySearch(int[] arr, int l, int r, int findVal, List<Integer> list) {
        if (l>r) return list;

        int midIndex = (l+r)/2;
        int midVal = arr[midIndex];

        if (midVal>findVal) {
            //向左进行递归查找
            return binarySearch(arr, l, midIndex - 1, findVal,list);
        } else if (midVal<findVal) {
            //向右进行递归查找
            return binarySearch(arr, midIndex + 1, r, findVal, list);
        } else {
            System.out.println("midIndex="+midIndex);
            //定义一个可变数组

            //向左边扫描
            int temp = midIndex-1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                if (arr[temp]==findVal) {
                    list.add(temp);
                }
                temp -= 1;
            }
            //将中间这个索引加入
            list.add(midIndex);
            //向右边扫描
            temp = midIndex + 1;
            while (true) {
                if (temp>arr.length-1 || arr[temp] != findVal) {
                    break;
                }
                if (arr[temp]==findVal) {
                    list.add(temp);
                }
                temp+=1;
            }
        }
        return list;
    }
}
