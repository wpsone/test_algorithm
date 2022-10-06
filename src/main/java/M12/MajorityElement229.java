package M12;

import java.util.ArrayList;
import java.util.List;

//229. 求众数 II
public class MajorityElement229 {
    public List<Integer> majorityElement(int[] nums) {
        int[] a = new int[2],b = new int[2];
        for (int num : nums) {
            if (a[0] == num) {
                a[1]++;
            } else if (b[0] == num) {
                b[1]++;
            } else if (a[1] == 0) {
                a[0] = num;
                a[1] = 1;
            } else if (b[1] == 0) {
                b[0] = num;
                b[1] = 1;
            } else {
                b[1]--;
                a[1]--;
            }
        }

        a[1]=0;
        b[1]=0;
        for (int num : nums) {
            if (num==a[0]   ) a[1]++;
            if (num==b[0]) b[1]++;
        }
        List<Integer> ret = new ArrayList<>();
        if (a[1]*3>nums.length) {
            ret.add(a[0]);
        }
        if (b[1]*3>nums.length && b[0]!=a[0]    ) {
            ret.add(b[0]);
        }
        return ret;
    }
}
