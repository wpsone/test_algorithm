package M10;

import java.util.Deque;
import java.util.LinkedList;

//32. 最⻓有效括号
public class LongestValidParentheses32 {
    //动态规划
//    public int longestValidParentheses(String s) {
//        int ans = 0;
//        int[] dp = new int[s.length()+5];
//        for (int i = 1,I=i+2; i < s.length(); i++,I++) {
//            if (s.charAt(i)=='(') continue;
//            if (s.charAt(i-1)=='(') dp[I]=dp[I-2]+2;
//            else {
//                int j = i-dp[I-1]-1;
//                if (j<0||s.charAt(j)==')') continue;
//                dp[I]=dp[I-1]+2+dp[j+1];
//            }
//            ans = Math.max(ans,dp[I]);
//        }
//        return ans;
//    }

    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.offerLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.offerLast(i);
                }else {
                    ans = Math.max(ans,i-stack.peekLast());
                }
            }
        }
        return ans;
    }
}
