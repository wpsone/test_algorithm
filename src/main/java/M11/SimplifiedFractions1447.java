package M11;

import java.util.ArrayList;
import java.util.List;

//1447. 最简分数
public class SimplifiedFractions1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i,j)!=1) continue;
                list.add(new StringBuffer().append(j).append('/').append(i).toString());
            }
        }
        return list;
    }

    int gcd(int a,int b) {
        if (b == 0) return a;
        return gcd(b,a%b);
    }
}
