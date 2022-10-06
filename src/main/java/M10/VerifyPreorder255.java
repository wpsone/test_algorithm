package M10;

import java.util.Deque;
import java.util.LinkedList;

//255. 验证前序遍历序列⼆叉搜索树
public class VerifyPreorder255 {
    int pre_ind;

    public boolean verifyPreorder(int[] preorder) {
        //单调栈
        Deque<Integer> stack = new LinkedList<>();
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            while (!stack.isEmpty() && stack.peekLast() <preorder[i]){
                pre = stack.pollLast();
            }
            if (preorder[i]<pre) return false;
            stack.offerLast(preorder[i]);
        }
        return true;

//        pre_ind=-1;
//        return inorder(preorder,0,preorder.length);
    }

    boolean inorder(int[] preorder,int l,int r) {
        if (r<=l) return true;
        int root = preorder[l];
        int ind = l+1;
        while (ind<r && root>preorder[ind]) ind++;
        if (!inorder(preorder,l+1,ind)) return false;
        if (pre_ind!=-1 && preorder[l]<preorder[pre_ind]) return false;
        pre_ind=l;
        if (!inorder(preorder,ind,r)) return false;
        return true;
    }
}
