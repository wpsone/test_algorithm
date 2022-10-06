package M10;

import java.util.ArrayList;
import java.util.List;

//⾯试题 17.17. 多次搜索
public class MultiSearch17_17 {
//    public int[][] multiSearch(String big,String[] smalls) {
//        ArrayList<Integer>[] lists = new ArrayList[smalls.length];
//        for (int i = 0; i < smalls.length; i++) {
//            lists[i]=sunday(big,smalls[i]);
//        }
//        int[][] res = new int[smalls.length      ][];
//        for (int i = 0; i < smalls.length; i++) {
//            res[i]=lists[i].stream().mapToInt(Integer::intValue).toArray();
//        }
//        return res;
//    }
//
//    public ArrayList<Integer> sunday(String s,String t) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        if (t.equals("")) return ret;
//        int[] bits = new int[128];
//        int s_len = s.length(),t_len = t.length();
//        for (int i = 0; i < t_len; i++) {
//            bits[t.charAt(i)]=i;
//        }
//        for (int i = 0; i+t_len <= s_len; ) {
//            boolean flag = true;
//            for (int j = 0; j < t_len; j++) {
//                if (s.charAt(i+j)==t.charAt(j)) continue;
//                flag = false;
//                break;
//            }
//            if (flag) {
//                ret.add(i);
//                i++;
//            } else if (i + t_len >= s_len) {
//                break;
//            } else {
//                i+=t_len-bits[s.charAt(i+t_len)];
//            }
//        }
//        return ret;
//    }

    //字典树
    public int[][] multiSearch(String big,String[] smalls) {
        Trie t = new Trie();
        int n = smalls.length;
        for (int i = 0; i < n; i++) {
            t.insert(smalls[i],i);
        }
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < big.length(); i++) {
            t.search(big.substring(i),lists,i);
        }
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            res[i] = lists[i].stream().mapToInt(Integer::intValue).toArray();
        }
        return res;
    }

    class Node {
        Node[] next = new Node[26];
        boolean flag = false;
        int ind = -1;
    }

    class Trie {
        Node root = new Node();
        void insert(String word,int idx) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                int ind = word.charAt(i)-'a';
                if (p.next[ind]==null) p.next[ind] = new Node();
                p=p.next[ind];
            }
            p.flag=true;
            p.ind=idx;
        }

        void search(String word, List<Integer>[] lists,int idx) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                int ind = word.charAt(i)-'a';
                if (p.next[ind]==null) return;
                p=p.next[ind];
                if (p.flag) {
                    lists[p.ind].add(idx);
                }
            }
        }
    }
}
