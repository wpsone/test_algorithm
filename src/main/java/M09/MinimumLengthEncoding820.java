package M09;


import java.util.Arrays;
import java.util.Comparator;

//820. 单词的压缩编码
public class MinimumLengthEncoding820 {
    public int minimumLengthEncoding(String[] words) {
        Tire tire = new Tire();
        int ans = 0;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        for (String word : words) {
            ans += tire.inseart(word);
        }
        return ans;
    }

    class Node {
        Node[] next = new Node[26];
        boolean flag = false;
    }

    class Tire {
        Node root = new Node();
        int inseart(String word) {
            String str = new StringBuffer(word).reverse().toString();
            Node p = root;
            boolean flag = false;
            for (char x : str.toCharArray()) {
                int ind = x - 'a';
                if (p.next[ind] == null) {
                    p.next[ind] = new Node();
                    flag = true;
                }
                p = p.next[ind];
            }
            p.flag = true;
            return flag?word.length()+1:0;
        }
    }
}


