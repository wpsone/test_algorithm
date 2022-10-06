package M08;

import java.util.ArrayList;
import java.util.List;

public class GetRow119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex==0) {
            ret.add(1);
            return ret;
        }
        int[][] dp = new int[2][rowIndex + 1];
        dp[0][0]=1;
//        dp[1][0]=1;
//        dp[1][1]=1;
        for (int i = 1; i <= rowIndex; i++) {
            int j=0;
            int ind = i % 2;
            int pre_ind = (ind==1?0:1);
            while (j <= i) {
                if (j==0) dp[ind][j]=1;
                else dp[ind][j]=dp[pre_ind][j-1]+dp[pre_ind][j];
                j++;
            }
//            dp[ind][j]=1;
        }
        for (int i :
                dp[rowIndex % 2]) {
            ret.add(i);
        }
        return ret;
    }
}
