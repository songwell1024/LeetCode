package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-03-07 16:05
 * @Modified by:
 **/
public class Code_114_FlattenBinaryTreeToLinkedList {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right =new TreeNode(5);
        root.left =  new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        flatten(root);

    }
}
