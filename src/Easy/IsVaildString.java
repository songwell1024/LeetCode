package Easy;

import java.util.Stack;

/**
 * 由于只包含字符的字符串'('，')'，'{'，'}'，'['和']'，确定输入字符串是有效的。
 如果输入字符串有效：
 必须使用相同类型的括号关闭左括号。
 必须以正确的顺序关闭左括号。
 请注意，空字符串也被视为有效
 * @author WilsonSong
 * @date 2018/9/23/023
 */
public class IsVaildString {

    public static boolean isValid(String s) {
        if (s.equals("")){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else {
                if (!stack.isEmpty()){
                    if (s.charAt(i) == ')' && stack.pop() !='('){
                        return false;
                    }else if (s.charAt(i) == '}' && stack.pop() != '{'){
                        return false;
                    }else if (s.charAt(i) == ']' && stack.pop() != '['){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] srgs){
        String s = "{";
        System.out.println(isValid(s));
    }
}


