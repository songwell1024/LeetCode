package getOffer;

import java.util.Stack;

/**
 * @program:
 * @description: 两个栈实现一个对列
 * @author: Song
 * @create: Created in 2019-03-11 16:08
 * @Modified by:
 **/
public class Code_05_StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}
