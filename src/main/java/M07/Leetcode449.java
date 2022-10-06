package M07;

import M07.Utils.*;

import java.util.Stack;

//449. 序列化和反序列化⼆叉搜索树
public class Leetcode449 {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder ret = new StringBuilder();
        ret.append(root.val);
        if (root.left == null && root.right == null) return ret.toString();
        ret.append('(');
        ret.append(serialize(root.left));
        if (root.right!=null){
            ret.append(',');
            ret.append(serialize(root.right));
        }
        ret.append(')');
        return ret.toString();
    }

    public TreeNode deserialize(String data) {
        int scode = 0;
        int ind = 0;
        // 判断当前构建的是左⼦树还是右⼦树
        int k = 0;
        TreeNode p = null,root = null;
        Stack<TreeNode> stack = new Stack<>();
        while (ind < data.length()) {
            switch (scode) {
                case 0:
                    if (data.charAt(ind) <= '9' && data.charAt(ind)>='0') scode = 1;
                    else if (data.charAt(ind) == '(') scode = 2;
                    else if (data.charAt(ind) == ',') scode = 3;
                    else if (data.charAt(ind) == ')') scode = 4;
                case 1:
                    int num = 0;
                    while (ind < data.length() && data.charAt(ind) <= '9' && data.charAt(ind) >= '0') {
                        num = num * 10 + (data.charAt(ind) - '0');
                        ind++;
                    }
                    p = new TreeNode(num);
                    if (root == null) root = p;
                    if (k == 1) stack.peek().left = p;
                    else if (k==2) stack.peek().right = p;
                    scode = 0;
                    break;
                case 2:
                    stack.push(p);
                    ind++;
                    k = 1;
                    scode = 0;
                    break;
                case 3:
                    k = 2;
                    ind++;
                    scode=0;
                    break;
                case 4:
                    stack.pop();
                    ind++;
                    scode=0;
                    break;
            }
        }
        return root;
    }
}
