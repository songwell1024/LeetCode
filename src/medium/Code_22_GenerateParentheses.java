package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author: Song
 * @create: Created in 2019-02-19 20:58
 * @Modified by:
 * 这道题目是回溯问题，当存在"("时就继续在该序列上放置"(",当还有")"并且数量小于"("时就放置")"
 **/
public class Code_22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n <= 0){
            return null;
        }
        List<String> resList = new ArrayList<>();
        process(resList,"", n, 0);
        return resList;
    }

    public void process(List<String> list, String s, int left, int right){
        if (left == 0 && right == 0){
            list.add(s);
        }

        if (left > 0){
            process(list, s + "(", left -1, right + 1);
        }
        if (right > 0){
            process(list, s + ")", left, right -1);
        }
    }
}
