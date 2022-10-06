package M10;

//1109. 航班预订统计
public class CorpFlightBookings1109 {

    public int[] corpFlightBookings(int[][] bookings,int n) {
        FenwickTree fenwickTree = new FenwickTree(n);
        for (int[] booking : bookings) {
            int l = booking[0],r=booking[1],x=booking[2];
            fenwickTree.add(l,x);
            fenwickTree.add(r+1,-x);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i]=fenwickTree.query(i+1);
        }
        return res;
    }

    class FenwickTree {
        int[] arr;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            arr = new int[n+1];
        }

        private int lowbit(int i) {
            return i & (-i);
        }

        public void add(int i,int x) {
            while (i<=n) {
                arr[i] += x;
                i+=lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i!=0) {
                sum += arr[i];
                i-=lowbit(i);
            }
            return sum;
        }
    }

}
