package M12;

import java.util.Arrays;

//914. 卡牌分组
public class HasGroupsSizeX914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int max = Arrays.stream(deck).max().getAsInt();
        int[] map = new int[max+1];
        for (int i : deck) {
            map[i]++;
        }
        int x = 0;
        for (int i = 0; i <= max; i++) {
            if (map[i]==0) continue;
            if (x == 0) x = map[i];
            else {
                x = gcd(x,map[i]);
            }
            if (x==1) break;
        }
        return x>1;
    }

    public int gcd(int a,int b) {
        if (b == 0) return a;
        return gcd(b,a%b);
    }
}
