package Easy;

/**
 * 您将获得一个二叉树，其中每个节点都包含一个整数值。
 *
 * 找到与给定值相加的路径数。
 *
 * 路径不需要在根或叶子处开始或结束，但必须向下（仅从父节点行进到子节点）。
 */
public class Code_437_PathSumOfBinaryTree {

    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

}
