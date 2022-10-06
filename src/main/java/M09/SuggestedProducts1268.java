package M09;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SuggestedProducts1268 {

    public List<List<String>> suggestedProducts(String[] products,String searchWord) {
        Trie tree = new Trie();
        for (String s : products) {
            tree.insert(s);
        }
        return tree.search(searchWord);
    }


    class Node {
        boolean flag;
        Node[] next;
        TreeSet<String> set = new TreeSet<>();

        public Node () {
            this.flag = false;
            next=new Node[26];
        }
    }

    class Trie {
        Node root;

        public Trie() {
            this.root=new Node();
        }

        boolean insert(String word) {
            Node p = root;
            for (char x : word.toCharArray()) {
                int ind = x - 'a';
                if (p.next[ind]==null) p.next[ind] = new Node();
                p=p.next[ind];
                p.set.add(word);
                if (p.set.size() > 3) {
                    p.set.pollLast();
                }
            }
            if (p.flag) return false;
            p.flag = true;
            return true;
        }

        List<List<String>> search(String word) {
            Node p = root;
            List<List<String>> ret = new ArrayList<>();
            for (char x : word.toCharArray()) {
                if (p == null) {
                    ret.add(new ArrayList<String>());
                    continue;
                }
                int ind = x-'a';
                p=p.next[ind];
                List<String> temp = new ArrayList<>();
                if (p != null) {
                    for (String s : p.set) {
                        temp.add(s);
                    }
                }
                ret.add(temp);
            }
            return ret;
        }
    }
}

