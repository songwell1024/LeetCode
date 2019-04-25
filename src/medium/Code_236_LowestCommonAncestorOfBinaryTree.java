package medium;

import java.util.*;

/**
 * @ClassName: Code_236_LowestCommonAncestorOfBinaryTree
 * @Description:
 * 给定二叉树，找到树中两个给定节点的最低共同祖先（LCA）。
 *
 * 根据维基百科上LCA的定义：“最低共同祖先在两个节点p和q之间定义为T中的最低节点，其中p和q都是后代（我们允许节点成为其自身的后代）。 ”
 * @Author: WilsonSong
 * @Date: 2019/4/22 15:07
 * @Version 1.0
 **/
public class Code_236_LowestCommonAncestorOfBinaryTree {
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    static HashMap<TreeNode, Integer> map = new HashMap<>();
     static HashSet<TreeNode> set ;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        TreeNode res = null;
        set = new HashSet<>();
        Stack<TreeNode> queue1 = new Stack<>();
        process(root,p,queue1);
        set = new HashSet<>();
        Stack<TreeNode> queue2 = new Stack<>();
        process(root,q,queue2);

        Stack<TreeNode> queue11 = new Stack<>();
        while (!queue1.isEmpty()){
            queue11.add(queue1.pop());
        }
        Stack<TreeNode> queue22 = new Stack<>();
        while (!queue2.isEmpty()){
            queue22.add(queue2.pop());
        }

        while (!queue11.isEmpty() && !queue22.isEmpty()){
            if (queue11.peek().val == queue22.peek().val){
                res = queue11.peek();
                queue11.pop();
                queue22.pop();
                if (queue11.isEmpty() || queue22.isEmpty() ||queue11.peek() != queue22.peek()){
                    return res;
                }
            }else {
                break;
            }
        }
        return res;
    }

    public static void process(TreeNode root, TreeNode node, Stack<TreeNode> queue){
         if (root == null){
             return;
         }
         queue.add(root);
         while (!queue.isEmpty()){
             TreeNode cur = queue.peek();
             if (cur.val == node.val){
                 return;
             }

             while (cur.left != null){
                 if (set.contains(cur.left)){
                     break;
                 }
                 cur = cur.left;
                 queue.add(cur);
                 if (cur.val == node.val){
                     return;
                 }
             }
             if (cur.right != null && !set.contains(cur.right) ){
                 cur = cur.right;
                 queue.add(cur);
                 if (cur.val == node.val){
                     return;
                 }
             }else {
//                 map.put(queue.pop(), 1);
                 set.add(queue.pop());
             }

         }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
//        root.left.left =  new TreeNode(6);
//        root.left.right =  new TreeNode(2);
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right =  new TreeNode(4);
//        root.right.left =  new TreeNode(0);
//        root.right.right = new TreeNode(8);
        lowestCommonAncestor(root, root.right , root.left);
    }
}
