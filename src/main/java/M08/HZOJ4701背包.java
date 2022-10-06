package M08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HZOJ4701背包 {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        int MAX_N=100;
        int MAX_V = 10000;
        int[] v = new int[MAX_N+5 ],w=new int[MAX_N+5];
        int[][] dp = new int[MAX_N + 5][MAX_V + 5];
        Scanner scanner = new Scanner(new FileInputStream("E://1.txt"));
        int V = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i]=scanner.nextInt();
            w[i]=scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j]=dp[i-1][j];
                if (j>=v[i])
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-v[i]]+w[i]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(dp[n][V]);
        System.out.println(end-start+"ms");
    }
}
