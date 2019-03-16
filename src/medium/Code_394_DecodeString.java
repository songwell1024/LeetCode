package medium;

import java.util.Stack;

/**
 * @program:
 * @description:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * @author: Song
 * @create: Created in 2019-03-04 15:05
 * @Modified by:
 **/
public class Code_394_DecodeString {
    public static String decodeString(String s) {
        if (s == null){
            return null;
        }
        if (s == ""){
            return "";
        }
        Stack<Character> stack = new Stack<>();
        String resStr = "";
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (c != ']'){
                stack.push(c);
            }else {
                String s1 = "";
                String s2 = "";
                while (!stack.isEmpty()&&!(stack.peek() >='0' && stack.peek() <= '9')){
                    if (stack.peek()== '['){
                        stack.pop();
                    }else {
                        s1 =  stack.pop()+ s1;
                    }

                }
                while (!stack.isEmpty()&&(stack.peek() >='0' && stack.peek() <= '9')){
                    s2 =  stack.pop()+ s2;
                }
                int index = Integer.parseInt(s2);
                while (index != 0){
                    char[] chars1 = s1.toCharArray();
                    for (char c1 : chars1){
                        stack.push(c1);
                    }
                    index --;
                }
            }
        }
        String ss = "";
        while(!stack.isEmpty()){
            ss = stack.pop() + ss;
        }
        return ss;
    }

    public static void main(String[] args) {
        String s = "20[a]";
        System.out.println(decodeString(s));
    }
}
