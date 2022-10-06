package M09;

public class Trie208 {
    class Node {
        boolean flag = false;
        Node[] next = new Node[26];
    }

    class Trie {
        Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node p = root;
            for (char x : word.toCharArray()) {
                int ind = x - 'a';
                if (p.next[ind]==null) p.next[ind] = new Node();
                p=p.next[ind];
            }
            p.flag = true;
        }

        public boolean search(String word) {
            Node p = root;
            for (char x : word.toCharArray()) {
                int ind = x - 'a';
                p = p.next[ind];
                if (p==null) return false;
            }
            return p.flag;
        }

        public boolean startsWith(String prefix) {
            Node p = root;
            for (char x : prefix.toCharArray()) {
                int ind = x - 'a';
                p = p.next[ind];
                if (p==null) return false;
            }
            return true;
        }
    }
}
