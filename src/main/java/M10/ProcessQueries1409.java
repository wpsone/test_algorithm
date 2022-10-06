package M10;

//1409. 查询带键的排列
public class ProcessQueries1409 {

    public int[] processQueries(int[] queries,int m) {
        int[] pos = new int[m+1];
        int len = queries.length;
        FenwickTree tree = new FenwickTree(queries.length+m);
        for (int i = 1; i <= m; i++) {
            tree.add(len+i,1);
            pos[i]=len+i;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int ind = pos[queries[i]];
            res[i] = tree.query(ind)-1;
            tree.add(ind,-1);
            tree.add(len-i,1);
            pos[queries[i]] = len - i;
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
                a[i] += x;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i != 0) {
                sum += a[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }
}
