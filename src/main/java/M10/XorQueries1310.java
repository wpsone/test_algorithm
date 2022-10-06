package M10;

//1310. ⼦数组异或查询
public class XorQueries1310 {
    public int[] xorQueries(int[] arr,int[][] queries) {
        FenwickTree tree = new FenwickTree(arr.length);
        for (int i = 0; i < arr.length; i++) {
            tree.add(i+1,arr[i]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0],r = queries[i][1];
            res[i] = tree.query(r+1) ^ tree.query(l);
        }
        return res;
    }

    class FenwickTree {
        int[] a;
        int n;

        public FenwickTree(int n) {
            a = new int[n+1];
            this.n = n;
        }

        private int lowbit(int i) {
            return i & (-i);
        }

        public void add(int i,int x) {
            while (i<=n) {
                a[i] ^= x;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i!=0) {
                sum ^= a[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }
}
