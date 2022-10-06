package M08;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveConveredIntervals1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]> () {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        int cnt = 0;
        int end,pre_end = 0;
        for (int[] interval : intervals) {
            end = interval[1];
            if (pre_end < end) {
                cnt++;
                pre_end=end;
            }
        }
        return cnt;
    }
}
