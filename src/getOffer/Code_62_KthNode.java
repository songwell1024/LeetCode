package getOffer;

import javax.swing.table.TableRowSorter;

/**
 * @program:
 * @description:
 * 二叉树的第K大的节点
 * @author: Song
 * @create: Created in 2019-03-27 16:30
 * @Modified by:
 **/
public class Code_62_KthNode {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null){
                return node;
            }
        }
        return null;
    }
}