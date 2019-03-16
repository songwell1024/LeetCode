package getOffer;

import java.util.Stack;

/**
 * @program:
 * @description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，\
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author: Song
 * @create: Created in 2019-03-14 16:21
 * @Modified by:
 **/
public class Code_21_IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++){
            if (!stack.isEmpty() && pushA[i] == popA[index]){
                index ++;
            }else {
                stack.push(pushA[i]);
            }
        }
        while (!stack.isEmpty()){
            if (stack.pop() != popA[index]){
                return false;
            }
            index ++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = {4,5,3,2,1};
        IsPopOrder(A,B);

    }
}
