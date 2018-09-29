package Easy;

/**
 * 二叉树的最大深度
 * @author WilsonSong
 * @date 2018/9/28/028
 */
public class MaximumDepthOfBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right  =new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);

        System.out.println(maxDepth(root));
    }
}
