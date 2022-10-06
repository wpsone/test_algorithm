package M09;

//745. 前缀和后缀搜索
public class WordFilter745 {

    Trie trie = new Trie();

    public WordFilter745(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String s = words[i]+"{"+words[i];
            int len = words[i].length();
            for (int j = 0; j <= len; j++) {
                trie.inseart(s,j,i);
            }
        }
    }

    public int f(String prefix,String suffix) {
        return trie.search(suffix+"{"+prefix);
    }

    class Node {
        Node[] next = new Node[27];
        int val = 0;
    }

    class Trie {
        Node root = new Node();

        void inseart(String word,int start,int _val) {
            Node p = root;
            int n = word.length();
            for (int i = start; i < n; i++) {
                int ind = word.charAt(i)-'a';
                if (p.next[ind]==null) p.next[ind]=new Node();
                p=p.next[ind];
                p.val = Math.max(p.val,_val);
            }
        }

        int search(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                int ind = c - 'a';
                if (p.next[ind]==null) return -1;
                p=p.next[ind];
            }
            return p.val;
        }
    }
}
