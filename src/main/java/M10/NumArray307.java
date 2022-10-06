package M10;

//307. 区域和检索 - 数组可修改
public class NumArray307 {

    FenwickTree tree;

    public NumArray307(int[] nums) {
        int n = nums.length;
        tree = new FenwickTree(n);
        for (int i = 1; i <= n; i++) {
            tree.add(i,nums[i-1]);
        }
    }

    public void update(int index,int val) {
        tree.add(index+1,val- tree.getNumOfInd(index+1));
    }

    public int sumRange(int left,int right) {
        return tree.query(right+1)- tree.query(left);
    }
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
            a[i] += x;
            i+=lowbit(i);
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i != 0) {
            sum += a[i];
            i -=lowbit(i);
        }
        return sum;
    }

    public int getNumOfInd(int i) {
        return query(i)-query(i-1);
    }
}
