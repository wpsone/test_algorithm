package M10;

//⾯试题 10.10. 数字流的秩
public class StreamRank10_10 {

    FenwickTree tree = new FenwickTree(50005);

    public StreamRank10_10() {

    }

    public void track(int x) {
        tree.add(x+1,1);
    }

    public int getRankOfNumber(int x) {
        return tree.query(x+1);
    }

    class FenwickTree {
        int[] a;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            a = new int[n+1];
        }

        private int lowbit(int i) {
            return i & (-i);
        }

        public void add(int i,int x) {
            while (i<=n) {
                a[i]+=x;
                i+=lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i!=0) {
                sum += a[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }
}




