package M09;

import java.util.ArrayList;
import java.util.List;


public class Utils {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val,ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
