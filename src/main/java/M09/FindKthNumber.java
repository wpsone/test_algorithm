package M09;

//440. 字典序的第K小数字
public class FindKthNumber {

    public int findKthNumber(int n,int k) {
        long cur = 1;
        while (k > 1) {
            long cnt = getCount(n,cur);
            if (cnt<k){
                cur++;
                k-=cnt;
            } else {
                cur*=10;
                k-=1;
            }
        }
        return (int) cur;
    }

    long getCount(int n,long cur     ) {
        long next = cur+1,cnt=0;
        while (cur <= n) {
            cnt += Math.min(next-cur,n-cur+1);
            cur*=10;
            next*=10;
        }
        return cnt;
    }
}
