package getOffer;

/**
 * @program:
 * @description:
 * 树的深度
 * @author: Song
 * @create: Created in 2019-03-22 14:22
 * @Modified by:
 **/
public class Code_38_TreeDepth {
     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
         }
     }
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
