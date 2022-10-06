package M07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//78. ⼦集
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        // 记录⼆进制下每个1对应数组的索引
        for (int i = 0,j=1; i < 10; i++,j*=2) {
            map.put(j,i);
        }
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0,I = (1<<n); i < I; i++) {
            List<Integer> ans = new ArrayList<>();
            int val = i;
            //val & (-val) : 找到当前数⼆进制下最后⼀个1
            // val &= (val - 1) : 去掉当前数⼆进制下最后⼀个1
            while (val != 0) {
                //根据每⼀个1 获取对应的数组索引，最后获取数组元素
                ans.add(nums[map.get(val & (-val))]);
                //删除使⽤过的1
                val &= (val-1);
            }
            ret.add(ans);
        }
        return ret;
    }
}
