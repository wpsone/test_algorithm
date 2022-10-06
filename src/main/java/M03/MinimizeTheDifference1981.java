package M03;

import java.util.HashSet;

//1981. 最⼩化⽬标值与所选元素的差
public class MinimizeTheDifference1981 {
    public int minimizeTheDifference(int[][ ] mat,int target    ) {
        HashSet<Integer>[] sets = new HashSet[2 ];
        sets[0] = new HashSet<>(    );
        sets[1] = new HashSet<>();
        int n = mat.length, sum = 0;
        for (int x : mat[0]) {
            sets[0].add(x);
            sum = Math.max(sum,x);
        }
        for (int i = 1; i < n; i++) {
            int ind=i & 1,pre_ind = ind^1;
            sets[ind].clear();
            int max_num = 0;
            for (int x : mat[i]) {
                max_num = Math.max(max_num,x    );
            }
            sum += max_num;
            for (int j = i+1; j <= sum; j++) {
                for (int x : mat[i]) {
                    if (!sets[pre_ind].contains(j-x )) continue;;
                    sets[ind].add(j);
                    break;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Integer x:sets[(n-1)%2]) ans = Math.min(ans,Math.abs(target-x  ));
        return ans;
    }
}
