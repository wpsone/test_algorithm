package M11;

//941. 有效的⼭脉数组
public class ValidMountainArray941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n<3) return false;
        int l = 0,r = n-1;
        while (l<n-1 && arr[l] < arr[l+1]) l++;
        while (r>0 && arr[r]<arr[r-1]) r--;
        return l==r && l!=0 && l != n-1;
    }
}
