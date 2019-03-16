package getOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @author: Song
 * @create: Created in 2019-03-15 14:58
 * @Modified by:
 **/
public class Code_24_FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
//    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        if (root == null){
//            return lists;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        process(list, root, target);
//        FindPath(root.left, target);
//        FindPath(root.right, target);
//        return lists;
//    }
//
//    public static void process(ArrayList<Integer> list, TreeNode node, int target){
//        if (target == 0){
//            if (!lists.contains(list)){
//                lists.add(new ArrayList<>(list));
//            }
//
//        }
//        if (node == null){
//            return;
//        }
//        list.add(node.val);
//        process(list,node.left, target - node.val);
//        process(list, node.right, target - node.val);
//        if (list.size() > 1){
//            list.remove(list.size() -1);
//        }
//    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list  =new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists  = new ArrayList<>();
        if (root == null){
            return lists;
        }

        process(root, target, list, lists);
        return lists;
    }

    public static void process(TreeNode node, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> lists){
        if (node == null){
            if (target == 0){
                if (!lists.contains(list)){
                    lists.add(new ArrayList<>(list));
                    return;
                }
                return;

            }
            return;

        }
        list.add(node.val);
        process(node.left, target - node.val,list, lists);
        process(node.right, target - node.val, list, lists);
        if (list.size() > 1){
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists =  FindPath(node,22);
        System.out.println("aaa");


    }
}
