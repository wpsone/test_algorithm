package M11;

import java.util.ArrayList;
import java.util.List;

//2100. 适合打劫银⾏的⽇⼦
public class GoodDaysToRobBank2100 {
    public List<Integer> goodDaysToRobBank(int[] security,int time) {
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int peak = 0,i = 0;

        while (i<n) {
            if (i==0) left[i] = 0;
            else {
                if (security[i]>security[i-1]) peak = i;
                left[i] = i - peak;
            }
            i++;
        }
        i = n - 1;
        peak = n -1;
        while (i>=0) {
            if (i==n-1) right[i]=0;
            else {
                if (security[i]>security[i+1]) peak = i;
                right[i] = peak - i;
            }
            i--;
        }
        List<Integer> ret = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (left[k] >= time && right[k] >= time) {
                ret.add(k);
            }
        }
        return ret;
    }
}
