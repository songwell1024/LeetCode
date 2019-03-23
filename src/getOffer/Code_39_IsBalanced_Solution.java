package getOffer;

/**
 * @program:
 * @description: 是否是平衡二叉树
 * @author: Song
 * @create: Created in 2019-03-22 14:30
 * @Modified by:
 **/
public class Code_39_IsBalanced_Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        return (Math.abs((getMaxDl(root.left) - getMaxDl(root.right))) <= 1) && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public static int getMaxDl(TreeNode node) {
       if (node == null){
           return 0;
       }
       return Math.max(1+ getMaxDl(node.left),1 + getMaxDl(node.right));
    }


    public class Solution {
        //后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次

        private boolean isBalanced=true;
        public boolean IsBalanced_Solution2(TreeNode root) {

            getDepth(root);
            return isBalanced;
        }
        public int getDepth(TreeNode root){
            if(root==null)
                return 0;
            int left=getDepth(root.left);
            int right=getDepth(root.right);

            if(Math.abs(left-right)>1){
                isBalanced=false;
            }
            return right>left ?right+1:left+1;
        }
    }
}
