package M11;

//754. 到达终点数字
public class ReachNumber754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = (int) Math.sqrt(2*target);
        while ((1+k)*k/2<target) k++;
        int d = (1+k)*k/2 - target;
        while ((d&1)!=0) {
            k++;
            d+=k;
        }
        return k;
    }
}
