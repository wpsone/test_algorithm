package M03;

import java.util.ArrayList;
import java.util.List;

//2178. 拆分成最多数⽬的正偶数之和
public class MaximumEvenSplit2178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 1   ) return res;
        for (long i = 2; i <= finalSum; i+=2) {
            finalSum -= i;
            if (finalSum<=i) i+=finalSum;
            res.add(i);
        }
        return res;
    }
}
