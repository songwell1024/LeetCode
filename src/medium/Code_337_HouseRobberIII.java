package medium;



import java.util.Map;

/**
 * @program:
 * @description: 小偷又发现了自己盗窃的新地方。这个区域只有一个入口，称为“根”。除了根，每个房子只有一个父母的房子。
 * 巡回演出后，聪明的小偷意识到“这个地方的所有房屋都形成了一棵二叉树”。
 * 如果两个直接连接的房子在同一个晚上被闯入，它将自动联系警方。
 * 确定小偷今晚可以抢劫的最大金额而不警告警察。
 * 其实就是递归，这个一组不相连的 根 + （左子树的左子树+ 左子树的右子树 +右子树的左子树+ 右子树的右子树）和 （左子树 + 右子树）中最大的那一个
 * @author: Song
 * @create: Created in 2019-02-20 21:07
 * @Modified by:
 **/
public class Code_337_HouseRobberIII {

    private class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = root.val;
        if (root.left != null && root.right != null){
            res += rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
            res = Math.max(res, rob(root.left) + rob(root.right));
        }else if (root.left != null){
            res += rob(root.left.left) + rob(root.left.right);
            res = Math.max(res, rob(root.left));
        }else if (root.right != null){
            res += rob(root.right.left) + rob(root.right.right);
            res = Math.max(res, rob(root.right));
        }
        return res;
    }
}
