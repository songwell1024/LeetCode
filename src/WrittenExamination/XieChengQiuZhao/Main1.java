package WrittenExamination.XieChengQiuZhao;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/4 18:55
 * @Version 1.0
 **/
public class Main1 {

    static String resolve(String expr) {
        while (expr.contains("(") && expr.contains(")")){
            int index = 0;
            while (index < expr.length()){
                if (expr.charAt(index) == '('){
                    break;
                }
                index++;
            }
            int cur = expr.length()-1;
            while (cur >=0){
                if (expr.charAt(cur) == ')'){
                    break;
                }
                cur--;
            }
            StringBuilder ss = new StringBuilder();
            for (int i = 0; i< index; i++){
                ss.append(expr.charAt(i));
            }
            for (int i = cur-1; i>index;i--){
                if (expr.charAt(i) == '('){
                    ss.append(')');
                }else if (expr.charAt(i) == ')'){
                    ss.append('(');
                }else {
                    ss.append(expr.charAt(i));
                }
            }
            for (int i = cur +1; i< expr.length();i++){
                ss.append(expr.charAt(i));
            }
            expr = ss.toString();
        }
        if (expr.contains(")") || expr.contains("(")){
            return " ";
        }else {
            return expr;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
