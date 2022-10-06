package M07;

import M07.Utils.*;

import java.util.ArrayList;
import java.util.List;

//653. 两数之和 IV - 输⼊ BST
public class FindTarget653 {
    public boolean findTarget(TreeNode root,int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int l=0,r=list.size()-1;
        while (l < r && (list.get(l) + list.get(r)) != k) {
            if ((list.get(l)+list.get(r))<k) l++;
            else r--;
        }
        return l<r;
    }

    public void inorder(TreeNode root,List<Integer> list) {
        if (root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
