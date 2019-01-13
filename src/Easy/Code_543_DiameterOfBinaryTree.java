package Easy;

/**
 * 二叉树的最长路径
 * 左子树的最长路径，右子树的最长路径， 或者是左子树的最大深度 + 右子树的最大深度 中的最大值
 */
public class Code_543_DiameterOfBinaryTree {

    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null){
            return 0;
        }

        int lPath = process(root.left);
        int rPath = process(root.right);

        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)),lPath + rPath -1);
    }

    public int process(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(process(root.left), process(root.right)) + 1;
    }


}
