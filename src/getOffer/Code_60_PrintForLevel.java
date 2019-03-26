package getOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program:
 * @description:
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author: Song
 * @create: Created in 2019-03-25 19:43
 * @Modified by:
 **/
public class Code_60_PrintForLevel {
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
        arrayList.add(pRoot);
        int index = 1;
        while (arrayList.size() != 0){
            ArrayList<Integer> list = new ArrayList<>();
            int help = 0;
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
            index  = help;
        }
        return arrayLists;
    }
}
