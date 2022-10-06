package M03;

//2151. 基于陈述统计最多好⼈数
public class MaximumGood2151 {
    public int maximumGood(int[][] statements) {
        int n = statements.length, ans = 0;
        for (int i = 0,I = 1<<n; i <= I - 1; i++) {
            if (!check(statements,i,n) ) continue;
            ans = Math.max(ans,Integer.bitCount(i));
        }
        return ans;
    }
    
    boolean check(int[][] g,int mark, int n) {
        for (int i = 0; i < n; i++) {
            if (((mark>>i)&1)==0) continue;
            for (int j = 0; j < n; j++) {
                if (g[i][j]==2) continue;
                if ((g[i][j] != ((mark >> j) & 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
