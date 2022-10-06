package M09;

//211. 添加与搜索单词 - 数据结构设计
public class WordDictionary211 {

    Tire tire = new Tire();

    public WordDictionary211() {

    }

    public void addWord(String word) {
        tire.inseart(word);
    }

    public boolean search(String word) {
        return tire.search(word);
    }


    class Node {
        Node[] next = new Node[26];
        boolean flag = false;
    }

    class Tire {
        Node root = new Node();

        void inseart(String word) {
            Node p = root;
            for (char c : word.toCharArray()) {
                int ind = c - 'a';
                if (p.next[ind]==null) p.next[ind]=new Node();
                p = p.next[ind];
            }
            p.flag = true;
        }

        boolean search(String word) {
            return __search(word,0,root);
        }

        boolean __search(String word,int ind,Node _root) {
            if (ind == word.length()) return _root.flag;
            char c = word.charAt(ind);
            if (c=='.') {
                for (int i = 0; i < 26; i++) {
                    if (_root.next[i]!=null && __search(word,ind+1,_root.next[i ])) return true;
                }
            } else {
                int i = c - 'a';
                if (_root.next[i]==null) return false;
                return __search(word,ind+1,_root.next[i     ]);
            }
            return false;
        }
    }

}
