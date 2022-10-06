package M09;

import M09.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//572. 另一棵树的子树
public class IsSubtree572 {
    public boolean isSubtree(TreeNode root,TreeNode subRoot) {
        List<Integer> s = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        preOrder(root,s);
        preOrder(subRoot,p);
        System.out.println(s.toString());
        System.out.println(p.toString());
        return Kmp(s,p);
    }

    void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            res.add(10001);
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }

    boolean Kmp(List<Integer> s,List<Integer> p) {
        int[] next = new int[p.size()];
        getNext(p,next);
        int n = s.size();
        for (int i = 0,j=-1; i < n; i++) {
            while (j!=-1 && !s.get(i).equals(p.get(j+1))) {
                j=next[j];
            }
            if (s.get(i).equals(p.get(j+1))) j++;
            if (j+1 == p.size()) return true;
        }
        return false;
    }
    void getNext(List<Integer> p,int[] next) {
        next[0]=-1;
        for (int i = 1,j=-1; i < p.size(); i++) {
            while (j!=-1 && p.get(i)!=p.get(j+1)) j=next[j];
            if (p.get(i)==p.get(j+1)) j++;
            next[i]=j;
        }
    }
}
