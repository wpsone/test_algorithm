package M10;

//676. 实现⼀个魔法字典
public class MagicDictionary676 {

    Trie trie = new Trie();

    public MagicDictionary676() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            trie.insert(s);
        }
    }

    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }

    class Trie {
        Node root = new Node();

        void insert(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                int ind = word.charAt(i)-'a';
                if (p.next[ind]==null) p.next[ind]=new Node();
                p=p.next[ind];
            }
            p.flag=true;
        }

        boolean search(String word) {
            return _search(word,root,0,true);
        }

        boolean _search(String word,Node p,int k,boolean flag) {
            if (k==word.length()) return p.flag && !flag;
            int ind = word.charAt(k)-'a';
            if (p.next[ind]!=null && _search(word,p.next[ind],k+1,flag)) return true;
            if (flag) {
                for (int i = 0; i < 26; i++) {
                    if (i==ind || p.next[i]==null) continue;
                    if (_search(word,p.next[i],k+1,!flag)) return true;
                }
            }
            return false;
        }
    }

    class Node {
        Node[] next = new Node[26];
        boolean flag = false;
    }
}
