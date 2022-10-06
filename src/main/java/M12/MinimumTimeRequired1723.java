package M12;

//1723. 完成所有⼯作的最短时间
public class MinimumTimeRequired1723 {
    // 尝试将任务分配给不同⼯⼈，然后进⾏分⼯种类的搜索。寻找出最少的时间
    int ans;

    public int minimumTimeRequired(int[] jobs,int k) {
        ans = Integer.MAX_VALUE;
        int[] worker = new int[k];
        dfs(jobs,0,worker,0);
        return ans;
    }

    void dfs(int[] jobs,int ind,int[] worker,int max_time) {
        if (ind == jobs.length) {
            ans = max_time;
            return;
        }
        int n = worker.length;
        for (int i = 0; i < n; i++) {
            if (worker[i]+jobs[ind]>ans) continue;
            worker[i] += jobs[ind];
            dfs(jobs,ind+1,worker,Math.max(max_time,worker[i]));
            worker[i]-=jobs[ind];
            if (worker[i]==0) break;
        }
    }
}
