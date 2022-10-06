package M09;

//421. 数组中两个数的最大异或值
//剑指 Offer II 067. 最大的异或
public class FindMaximumXOR421 {

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.inseart(num);
        }
        int ans =0;
        for (int num : nums) {
            ans = Math.max(ans,trie.search(num));
        }
        return ans;
    }

    class Node {
        boolean flag = false;
        Node[] next = new Node[2];
    }

    class Trie {
        Node root = new Node();

        public void inseart(int x) {
            Node p = root;
            for (int i = 30; i >= 0; i--) {
                int ind = x >> i & 1;
                if (p.next[ind]==null) p.next[ind]=new Node();
                p=p.next[ind];
            }
        }

        public int search(int x) {
            Node p = root;
            int ans = 0;
            for (int i = 30; i >= 0; i--) {
                int ind = x>>i & 1;
                if (p.next[1 ^ ind] != null) {
                    ans |= (1<<i);
                    p=p.next[1^ind];
                } else {
                    p=p.next[ind];
                }
            }
            return ans;
        }
    }
}
