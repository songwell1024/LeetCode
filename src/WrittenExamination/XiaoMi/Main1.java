package WrittenExamination.XiaoMi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/6 19:42
 * @Version 1.0
 **/
public class Main1 {
    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;

        public int val;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            } else {
                if (c >= '0' && c <= '9') {
                    int start = i;
                    while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                        i++;
                    }
                    TreeNode node = new TreeNode(Integer.valueOf(s.substring(start, i + 1)));
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if (parent.left != null) {
                            parent.right = node;
                        } else {
                            parent.left = node;
                        }
                    }
                    stack.push(node);
                }
            }
        }
        if(stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }
    public static void midOrder(StringBuilder sb, TreeNode root){
        if (root == null){
            return;
        }
        midOrder(sb, root.left);
        sb.append(root.val);
        midOrder(sb,root.right);
    }

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
//        input = input.replace(',','(');
        TreeNode root = str2tree(input);
        StringBuilder sb = new StringBuilder();
        midOrder(sb,root);
        return sb.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
