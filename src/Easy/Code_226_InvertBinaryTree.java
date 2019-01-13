package Easy;

public class Code_226_InvertBinaryTree {

    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = invertTree(root.right);
        head.right = invertTree(root.left);
        return head;
    }
}
