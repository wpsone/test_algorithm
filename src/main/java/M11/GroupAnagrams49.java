package M11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Double,List<String>> map = new HashMap<>();
        int[] primes = get_primes();
        for (String str : strs) {
            double temp = 1;
            for (char c : str.toCharArray()) {
                temp *= primes[c-'a'+1];
            }
            List<String> list = map.getOrDefault(temp,new ArrayList<String>());
            list.add(str);
            map.put(temp,list);
        }
        return new ArrayList<>(map.values());
    }

    public int[] get_primes() {
        int n = 120;
        int[] primes = new int[n+5];
        for (int i = 2; i <= n; i++) {
            if (primes[i]==0) primes[++primes[0]] = i;
            for (int j = 1; j <= primes[0]; j++) {
                if (primes[j]*i>n) break;
                primes[primes[j]*i] = 1;
                if (i%primes[j]==0) break;
            }
        }
        return primes;
    }
}
