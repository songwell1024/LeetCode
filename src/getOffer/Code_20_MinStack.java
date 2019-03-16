package getOffer;

import java.util.Stack;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-03-14 15:58
 * @Modified by:
 **/
public class Code_20_MinStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (!minStack.isEmpty() && minStack.peek() < node){
            int help = minStack.pop();
            minStack.push(node);
            minStack.push(help);
        }else {
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        while (!stack.contains(minStack.peek())){
             minStack.pop();
        }
        return minStack.peek();

    }
}
