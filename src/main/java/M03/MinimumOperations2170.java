package M03;

import java.util.HashMap;
import java.util.Map;

//2170. 使数组变成交替数组的最少操作数
public class MinimumOperations2170 {
    public int minimumOperations(int[] nums) {
        int[] x1 = {0,0},
                x2 = {0,0},
                y1 = {0,0},
                y2 = {0,0};
        getMaxNums(0,x1,x2,nums);
        getMaxNums(1,y1,y2,nums);
        int n = nums.length;
        int n0 = (n+1   )/2;
        int n1 = n - n0;
        if (x1[0]!=y1[0]) return n0-x1[1]+n1-y1[1];
        return Math.min(n0-x2[1]+n1-y1[1],n0-x1[1]+n1-y2[1]);
    }
    
    private void getMaxNums(int p,int[] x1,int[] x2,int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = p,n=nums.length; i < n; i+=2) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(),val = entry.getValue();
            if (val>x1[1]) {
                x2[0] = x1[0];
                x2[1] = x1[1];
                x1[0] = key;
                x1[1] = val;
            } else if (val>x2[1]){
                x2[0] = key;
                x2[1] = val;
            }
        }
    }
}
