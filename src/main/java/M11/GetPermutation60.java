package M11;

//60. 排列序列
public class GetPermutation60 {
    public int pick(int n,int[] mark) {
        int cnt = 0,i=0;
        do {
            i++;
            cnt+=mark[i]==0?1:0;
        } while (cnt<n);
        mark[i]=1;
        return i;
    }

    public String getPermutation(int n,int k) {
        int[] mark = new int[n+1];
        int x = 1;
        for (int i = 1; i < n; i++) {
            x*=i;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n; i >= 1; i--) {
            int ind = (k-1)/x + 1;
            stringBuffer.append(pick(ind,mark));
            k -= (ind-1)*x;
            if (i>1) x/= i-1;
        }
        return stringBuffer.toString();
    }
}
