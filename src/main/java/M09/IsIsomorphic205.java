package M09;

import java.util.HashMap;

//205. 同构字符串
public class IsIsomorphic205 {
    public boolean isIsomorphic(String s,String t) {
        HashMap<Character,Character> s_map = new HashMap<>();
        HashMap<Character,Character> t_map = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i),ti = t.charAt(i);
            if ((s_map.containsKey(si) && s_map.get(si)!=ti) ||
                    (t_map.containsKey(ti) && t_map.get(ti)!=si)    ) {
                return false;
            }
            s_map.put(si,ti);
            t_map.put(ti,si);
        }
        return true;
    }
}
