package M08;

//461. 汉明距离
public class HammingDistance461 {
    public int hammingDistance(int x,int y) {
        x ^= y;
        //return Integer.bitCount(x);

        int cnt = 0;
        while (x != 0) {
            x &= (x-1);
            cnt++;
        }
        return cnt;
    }
}
