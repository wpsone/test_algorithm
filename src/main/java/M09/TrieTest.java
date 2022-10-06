package M09;

import java.util.Scanner;

//字典树（Trie）与双数组字典树（Double-Array- Trie)
public class TrieTest {

    //双数组字典树（Double-Array- Trie)
    static class Node {
        int[] next = new int[26];
        boolean flag=false;
    }

    static Node[] trie = new Node[10000];
    static int root,cnt;

    static void init() {
        root=1;
        cnt=2;
        trie[root]=new Node();
    }

    static int getNewNode() {
        trie[cnt]=new Node();
        return cnt++;
    }

    static void inseart(String str) {
        int p=root;
        for (char c : str.toCharArray()) {
            int ind=c-'a';
            if (trie[p].next[ind]==0) trie[p].next[ind]=getNewNode();
            p=trie[p].next[ind];
        }
        trie[p].flag=true;
    }

    static void output() {
        __output(root,"");
    }

    private static void __output(int root,String s) {
        if (trie[root]==null) return;
        for (int i = 0; i < 26; i++) {
            if (trie[root].next[i]==0) continue;
            if (trie[trie[root].next[i]].flag) {
                System.out.println(s+(char)(i+'a'));
            }
            __output(trie[root].next[i],s+(char)(i+'a'));
        }
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            inseart(sc.next());
        }
        output();

        //字典树
//        while (true) {
//            int op = sc.nextInt();
//            switch (op) {
//                case 1:
//                    inseart(sc.next());
//                    break;
//                case 2:
//                    System.out.println(search(sc.nextInt()));
//                    break;
//            }
//        }
    }
}

class Node {
    Node[] next = new Node[26];
    boolean flag = false;
}

class Trie {
    Node root = new Node();
    void inseart(String str) {
        Node p = root;
        for (char c : str.toCharArray()) {
            int ind = c - 'a';
            if (p.next[ind]==null) p.next[ind]=new Node();
            p=p.next[ind];
        }
        p.flag=true;
    }

    boolean search(String str) {
        Node p = root;
        for (char c : str.toCharArray()) {
            int ind = c - 'a';
            if (p.next[ind]==null) return false;
            p=p.next[ind];
        }
        return p.flag;
    }

    void output() {
        __output(root,"");
    }

    private void __output(Node root,String s) {
        if (root==null) return;
        for (int i = 0; i < 26; i++) {
            if (root.next[i]==null) continue;
            if (root.next[i].flag) {
                System.out.println(s+(char)(i+'a'));
            }
            __output(root.next[i],s+(char)(i+'a'));
        }
    }
}