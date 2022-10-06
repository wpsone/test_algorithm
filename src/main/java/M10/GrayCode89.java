package M10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//89. 格雷编码
public class GrayCode89 {
    public List<Integer> grayCode(int n) {
        Integer[] res = new Integer[1<<n];
        if (n == 0) {
            res[0]=0;
            return new ArrayList<>(Arrays.asList(res));
        }
        //0 1
        List<Integer> pre = grayCode(n-1);
        int len=pre.size();
        for (int i = 0; i < len; i++) {
            res[i]=pre.get(i)<<1;
            res[2*len-i-1] = pre.get(i)<<1 | 1;
        }
        return new ArrayList<>(Arrays.asList(res));
    }
}
