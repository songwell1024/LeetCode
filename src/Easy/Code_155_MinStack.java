package Easy;

import java.util.Stack;

/**
 * 两个栈，有一个存的是最小值
 * 设计一个支持push，pop，top和在恒定时间内检索最小元素的堆栈。
 push（x） - 将元素x推入堆栈。
 pop（） - 删除堆栈顶部的元素。
 top（） - 获取顶部元素。
 getMin（） - 检索堆栈中的最小元素。
 * @author WilsonSong
 * @date 2019/1/9/009
 */
public class Code_155_MinStack {

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()){
                minStack.push(x);
            }else if (minStack.peek() >= x){
                minStack.push(x);
            }
        }

        public void pop() {
            int x = stack.pop();
            if (x <= minStack.peek()){
                minStack.pop();
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
