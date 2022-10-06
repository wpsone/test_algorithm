package M03;

import java.util.Arrays;

//2187. 完成旅途的最少时间
public class MinimumTime2187 {
    public long minimumTime(int[] time,int totalTrips) {
        long l,r;
        l = 0;
        r = (long) Arrays.stream(time).min().getAsInt()*totalTrips;
        return binnarSearch(time,l,r,(long)totalTrips);
    }
    
    private long binnarSearch(int[] time,long l,long r,long totalTrips) {
        while (l < r) {
            long mid = (l+r )/2;
            if (check(mid, time) < totalTrips) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    
    private long check(long mid,int[] time) {
        long ans = 0;
        for (int x : time) {
            ans += mid / x;
        }
        return ans;
    }
}
