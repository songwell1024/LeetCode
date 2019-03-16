package getOffer;

/**
 * @program:
 * @description: 二叉树的镜像
 *           8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @author: Song
 * @create: Created in 2019-03-14 14:25
 * @Modified by:  递归，根的右子树变为翻转的左子树，根的左子树变为翻转的右子树
 **/
public class Code_18_MirrorTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        root = process(root);
    }

    public TreeNode process(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode help = node.left;
        node.left = process(node.right);
        node.right = process(help);
        return node;
    }
}
