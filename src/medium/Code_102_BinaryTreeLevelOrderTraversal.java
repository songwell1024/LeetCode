package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:
 * @description: Given a binary tree, return the level order traversal of
 *  its nodes' values. (ie, from left to right, level by level).
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author: Song
 * @create: Created in 2019-02-21 20:10
 * @Modified by:
 **/
public class Code_102_BinaryTreeLevelOrderTraversal {

        private static class TreeNode{
            TreeNode left;
            TreeNode right;
            int val;

            public TreeNode(int val){
                this.val = val;
            }
        }
        public static List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null){
                return null;
            }
            List<List<Integer>> resLists = new ArrayList<>();
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            while (!list.isEmpty()){
                List<TreeNode> helpList = new ArrayList<>();
                List<Integer> IList = new ArrayList<>();
                for (int i = 0; i< list.size(); i++){
                    IList.add(list.get(i).val);
                    if (list.get(i).left != null){
                        helpList.add(list.get(i).left);
                    }
                    if (list.get(i).right != null){
                        helpList.add(list.get(i).right);
                    }

                }
                resLists.add(IList);
                list = new ArrayList<>(helpList);
            }

            return resLists;
        }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

        public static void main(String[] args){
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);
            List<List<Integer>> lists =  levelOrder(root);
        }
}
