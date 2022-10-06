package M10;

//304. ⼆维区域和检索 - 矩阵不可变
public class NumMatrix304 {
    int[][] arr;
    int[][] sum;
    int n,m;

    public NumMatrix304(int[][] matrix) {
        arr = matrix;
        n = arr.length;
        m = arr[0].length;
        sum = new int[n+1][m+1];
        init();
    }

    void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]+arr[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1,int col1,int row2,int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return sum[row2][col2]-sum[row2][col1-1]-sum[row1-1][col2]+sum[row1-1][col1-1];
    }
}
