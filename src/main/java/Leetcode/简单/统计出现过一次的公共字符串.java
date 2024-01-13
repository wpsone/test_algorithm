package Leetcode.简单;

import java.util.HashMap;
import java.util.Map;

public class 统计出现过一次的公共字符串 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (String str1 : words1) {
            if (!map1.containsKey(str1)) {
                map1.put(str1, 1);
                continue;
            }
            if (map1.containsKey(str1)) {
                map1.put(str1, map1.get(str1) + 1);
            }
        }

        Map<String, Integer> map2 = new HashMap<>();
        int count = 0;
        for (String str2 : words2) {
            if (!map2.containsKey(str2)) {
                map2.put(str2, 1);
                if (map1.containsKey(str2) && map1.get(str2) == 1) {
                    count++;
                }
                continue;
            }
            if (map2.containsKey(str2)) {
                map2.put(str2, map2.get(str2) + 1);
                if (map1.containsKey(str2) && map2.get(str2) == 2 && map1.get(str2) == 1) {
                    count--;
                }
            }
        }
        return count;
    }

    public int countWords1(String[] words1, String[] words2) {
        // 统计字符串出现次数
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String str1 : words1) {
            map1.put(str1, map1.getOrDefault(str1, 0) + 1);
        }
        for (String str2 : words2) {
            map2.put(str2, map2.getOrDefault(str2, 0) + 1);
        }

        // 遍历words1出现的字符并判断是否满足要求
        int res = 0;
        for (String str : map1.keySet()) {
            if (map1.get(str) == 1 && map2.getOrDefault(str, 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
