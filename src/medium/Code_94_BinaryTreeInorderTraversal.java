package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @author WilsonSong
 * @date 2019/1/5/005
 */
public class Code_94_BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        process(root,list);
        return list;
    }

    public void process(TreeNode node, LinkedList<Integer> linkedList){
        if (node == null){
            return;
        }

        process(node.left, linkedList);
        linkedList.add(node.val);
        process(node.right, linkedList);
    }



}
