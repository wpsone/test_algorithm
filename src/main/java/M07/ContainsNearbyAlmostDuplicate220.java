package M07;

import java.util.TreeMap;

//220. 存在重复元素 III
public class ContainsNearbyAlmostDuplicate220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums,int k,int t) {
        TreeMap<Long,Integer> map = new TreeMap<>();
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i]=nums[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > k) {
                delNum(map,arr[i-k-1]);
            }
            map.put(arr[i]-t-1,map.getOrDefault(arr[i]-t-1,0)+1);
            map.put(arr[i]+t+1,map.getOrDefault(arr[i]+t+1,0)+1);
            long key = map.higherKey(arr[i]-t-1);
            if (key<arr[i]+t+1) return true;
            delNum(map,arr[i]-t-1);
            delNum(map,arr[i]+t+1);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return false;
    }

    private void delNum(TreeMap<Long,Integer> map,long x) {
        map.put(x,map.get(x)-1);
        if (map.get(x)==0) map.remove(x);
    }
}
