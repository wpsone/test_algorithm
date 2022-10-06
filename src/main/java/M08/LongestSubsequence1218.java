package M08;

//1218. 最⻓定差⼦序列
public class LongestSubsequence1218 {
    public int longestSubsequence(int[] arr,int difference) {
        int[] dp = new int[20001];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] += 10000;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int x = arr[i]-difference;
            if (x<0||x>20000) {
                dp[arr[i]]=1;
            } else {
                dp[arr[i]] = Math.max(dp[arr[i]],dp[x]+1);
            }
            ret= ret>=dp[arr[i]]?ret:dp[arr[i]];
        }
        return ret;
    }
}
