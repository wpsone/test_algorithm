package HuaWei;

import java.util.*;
import java.util.stream.Stream;

/**
 * 对一个非空字符串input中的字符进行重新组合，并返回重新组合后的结果
 * 规则如下：
 * 1.字符串input都由小写字母组成
 * 2.给定一个整数interval，使得重新组合后的字符串中相同字母的位置间隔至少为interval
 * 3.如果无法完成重新组合，则返回一个空字符串""
 */
public class Question002 {
    public static String combineChars(String input, int interval) {
        int len = input.length();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            if (max < map.get(c)) {
                max=map.get(c);
                System.out.println(max);
            }
//            System.out.println(Math.ceil((double) len/(double)interval));
            if (max > Math.ceil((double) len/(double) interval)) {
                return "";
            }
        }
        
        Map<Character,Integer> mapSortByV = new HashMap<>();
        Stream<Map.Entry<Character, Integer>> stream = map.entrySet().stream();
        stream.sorted(Comparator.comparing(e->e.getKey()))
        .forEach(e->{
            mapSortByV.put(e.getKey(),e.getValue());
            System.out.println(e.getKey()+"=="+e.getValue());
        });

        String result="";
        while (len > 0) {
            Iterator<Map.Entry<Character, Integer>> iterator = mapSortByV.entrySet().iterator();
            while (iterator.hasNext()) {
                Character c = iterator.next().getKey();
                result+=c.toString();
                len--;
                int num = mapSortByV.get(c);
                if (num > 1) {
                    mapSortByV.put(c,num-1);
                } else if (num == 1) {
                    iterator.remove();
                }
                if (mapSortByV.isEmpty()) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = combineChars("aaabc", 2);
        System.out.println(result);
    }
}
