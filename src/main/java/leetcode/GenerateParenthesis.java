package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author jzt
 * @version 1.0
 * @date 2021/5/23 4:17 下午
 **/
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res = help(res,i);
        }
        return res;
    }

    private List<String> help(List<String> genParenthesis,int n){
        List<String> res = new ArrayList<>();
        if (n==1){
            res.add("()");
            return res;
        }
        StringBuilder index0 =  new StringBuilder();
       for (String parenthesis : genParenthesis) {
            res.add("("+parenthesis+")");
        }
        genParenthesis.remove(genParenthesis.size()-1);
        for (String parenthesis : genParenthesis) {
            res.add(parenthesis+"()");
            res.add("()"+parenthesis);
        }
        for (int i = 0; i < n; i++) {
            index0.append("()");
        }
        res.add(index0.toString());
        return res;
    }
}
