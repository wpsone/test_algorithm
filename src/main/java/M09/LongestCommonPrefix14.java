package M09;

//14. 最长公共前缀
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            if (str.equals("")) return "";
            trie.insert(str);
        }
        String ret = "";
        Node p = trie.root;
        while (p != null) {
            int ind = 0;
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if (p.next[i]==null) continue;
                if (flag) return ret;
                ind = i;
                flag = true;
            }
            ret+=(char)(ind+'a');
            p=p.next[ind];
            if (p.flag) return ret;
        }
        return ret;
    }


    class Node {
        boolean flag = false;
        Node next[] = new Node[26];
    }

    class Trie {
        Node root = new Node();
        public void insert(String str) {
            Node p = root;
            for (char c : str.toCharArray()) {
                int ind = c - 'a';
                if (p.next[ind]==null) p.next[ind]= new Node();
                p = p.next[ind];
            }
            p.flag=true;
        }
    }
}


