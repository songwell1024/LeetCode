package getOffer;

/**
 * @program:
 * @description:
 * 判断树是不是对称二叉树
 * @author: Song
 * @create: Created in 2019-03-25 18:40
 * @Modified by:
 **/
public class Code_58_isSymmetrical {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }
        return process(pRoot.left, pRoot.right);
    }

    public static boolean process(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if (left!= null && right != null){
            if (left.val == right.val){
                return process(left.left, right.right) && process(left.right, right.left);
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        isSymmetrical(root);
    }
}
