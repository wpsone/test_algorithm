// 归并排序

/**
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * 算法描述
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MegreSort {
    public static int[] mergeSort(int[] nums,int l,int h) {
        if (l==h)
            return new int[]{nums[l]};
        int mid = l + (h - l)/2;
        int[] leftArr = mergeSort(nums,l,mid);//左有序数组
        int[] rightArr = mergeSort(nums,mid+1,h);//右有序数组
        int[] newNum = new int[leftArr.length+rightArr.length];//新有序数组

        int m = 0,i =0,j=0;
        while (i<leftArr.length && j<rightArr.length) {
            newNum[m++]=leftArr[i]<rightArr[j]?leftArr[i++]:rightArr[j++];
        }
        while (i<leftArr.length)
            newNum[m++]=leftArr[i++];
        while (j<rightArr.length)
            newNum[m++]=rightArr[j++];
        return newNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 10 };
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        for (int x : newNums) {
            System.out.println(x);
        }
    }
}
