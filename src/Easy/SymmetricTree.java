package Easy;

/**
 * 给定二叉树，检查它是否是自身的镜像（即，围绕其中心对称）。
 例如，这个二叉树[1,2,2,3,4,4,3]是对称的：
     1
    / \
   2   2
  / \ / \
 3  4 4  3
 但以下[1,2,2,null,3,null,3] 不是：
 其实思路就是每一层的左子树的左节点和右子树的右节点进行比较
 * @author WilsonSong
 * @date 2018/9/28/028
 */
public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return process(root.left, root.right);

    }

    public static boolean process(TreeNode left, TreeNode right){
        if (left != null && right != null){
            if (left.val != right.val){
                return false;
            }
        }else if (left == null && right == null){
            return true;
        }else {
            return false;
        }

        return process(left.left, right.right) &&  process(left.right, right.left);

    }

    public static void main(String[] args){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(3);

        head.left.left.left = new TreeNode(5);
        head.left.left.right = new TreeNode(6);
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(8);

        head.right.left.left = new TreeNode(8);
        head.right.left.right = new TreeNode(7);
        head.right.right.left = new TreeNode(6);
        head.right.right.right = new TreeNode(5);

        System.out.println(isSymmetric(head));
    }


}
