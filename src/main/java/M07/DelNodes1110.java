package M07;

import M07.Utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//1110. 删点成林
public class DelNodes1110 {
    Set<Integer> set;
    List<TreeNode> ret;

    public List<TreeNode> delNodes(TreeNode root,int[] to_delete){
        set = new HashSet<>();
        ret = new ArrayList<>();
        for (int i : to_delete) {
            set.add(i);
        }
        if (!set.contains(root.val)) ret.add(root);
        preorder(root);
        return ret;
    }

    private TreeNode preorder(TreeNode root) {
        if (root==null) return root;
        root.left = preorder(root.left);
        root.right = preorder(root.right);
        if (set.contains(root.val)){
            if (root.left!=null) ret.add(root.left);
            if (root.right!=null) ret.add(root.right);
            root=null;
        }
        return root;
    }
}
