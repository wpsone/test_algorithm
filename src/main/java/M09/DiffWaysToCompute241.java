package M09;

import java.util.ArrayList;
import java.util.List;

//241. 为运算表达式设计优先级
public class DiffWaysToCompute241 {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char op = expression.charAt(i);
            if (op != '+' && op != '-' && op != '*') continue;
            String l_str = expression.substring(0, i);
            String r_str = expression.substring(i + 1);
            List<Integer> l_res = diffWaysToCompute(l_str);
            List<Integer> r_res = diffWaysToCompute(r_str);
            for (Integer x : l_res) {
                for (Integer y : r_res) {
                    switch (op) {
                        case '+':
                            res.add(x+y);
                            break;
                        case '-':
                            res.add(x-y);
                            break;
                        case '*':
                            res.add(x*y);
                            break;
                    }
                }
            }
        }
        if (res.size()==0) {
            int num = 0;
            for (int i = 0; i < n; i++) {
                num=num*10+expression.charAt(i)-'0';
            }
            res.add(num);
        }
        return res;
    }
}
