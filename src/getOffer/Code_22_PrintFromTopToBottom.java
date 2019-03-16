package getOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program:
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层序遍历
 * 思路一：准备两个栈，
 *          1
 *         / \
 *        2  3
 *        /\ /\
 *       4 5 6 7
 *       stack 1 放1，然后stack1不是空，弹出来放入stack2，stack2中开始从栈顶弹元素，
 *       只要弹出的节点元素左右子节点不为空就把左右子节点放入stack1中，同时将该节点放入返回的list中
 *       直到stack1和stack2都是空
 *  思路二：
 *  准备一个队列，ArrayList就是一个对列，每次拿对列头部节点，然后该节点的左右子树不为空再放入队列中，直到为空
 * @author: Song
 * @create: Created in 2019-03-14 16:47
 * @Modified by:
 **/
public class Code_22_PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list =  new ArrayList<>();
        if (root == null){
            return list;
        }


        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }

            if (!stack2.isEmpty()){
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.left != null){
                        stack1.push(node.left);
                    }
                    if (node.right != null){
                        stack1.push(node.right);
                    }
                }
            }
        }
        return list;
    }

    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<TreeNode> queue = new ArrayList<>();
            if (root == null) {
                return list;
            }
            queue.add(root);
            while (queue.size() != 0) {
                TreeNode temp = queue.remove(0);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                list.add(temp.val);
            }
            return list;
        }
    }
}
