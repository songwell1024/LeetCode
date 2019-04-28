package getOffer;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program:
 * @description:
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * @author: Song
 * @create: Created in 2019-03-25 19:17
 * @Modified by:
 **/
public class Code_59_ZigZagPrintTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        if (pRoot == null){
            return arrayLists;
        }
        boolean flag = true;
        arrayList.add(pRoot);
        int index = 1;
        Stack<Integer> stack = new Stack<>();
        while (arrayList.size() != 0){
            ArrayList<Integer> list = new ArrayList<>();
            int help = 0;
            if (flag){
                while (index > 0){
                    TreeNode node = arrayList.get(0);
                    list.add(node.val);
                    arrayList.remove(0);
                    index --;
                    if (node.left != null){
                        arrayList.add(node.left);
                        help++;
                    }
                    if (node.right != null){
                        arrayList.add(node.right);
                        help++;
                    }
                }
                arrayLists.add(list);
                flag = false;
                index  = help;
            }else {
                while (index > 0){
                    TreeNode node = arrayList.get(0);
                    stack.push(node.val);
                    arrayList.remove(0);
                    index --;
                    if (node.left != null){
                        arrayList.add(node.left);
                        help++;
                    }
                    if (node.right!= null){
                        arrayList.add(node.right);
                        help++;
                    }
                }
                while (!stack.isEmpty()){
                    list.add(stack.pop());
                }
                arrayLists.add(list);
                flag = true;
                index  = help;
            }
        }
        return arrayLists;
    }


    /**
     * 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，
     * 在海量数据时，这样效率太低了。
     * （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，
     * 直接被鄙视了，面试官说海量数据时效率根本就不行。）
     *
     * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
     * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
     *     1)可用做队列,实现树的层次遍历
     *     2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
     */
    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode> iter = null;
                if (leftToRight) {
                    iter = queue.iterator();//从前往后遍历
                } else {
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()) {
                    TreeNode temp = (TreeNode)iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return ret;
    }

}
