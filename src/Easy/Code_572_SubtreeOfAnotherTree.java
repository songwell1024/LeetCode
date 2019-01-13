package Easy;

/**
 * 给定两个非空二进制树s和t，检查树t是否具有完全相同的结构和具有子树s的节点值。
 * 子树小号是一个树由一个节点的小号和所有这个节点的后代的。树小号也可以被认为是其自身的子树。
 */

public class Code_572_SubtreeOfAnotherTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(process(s,t)){
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right,t);
    }

    public static boolean process(TreeNode s, TreeNode t){
        if (s == null && t ==null){
            return true;
        }
        if (s == null && t != null){
            return false;
        }

        if (s != null && t ==null){
            return false;
        }
        if (s.val != t.val){
            return false;
        }
        return process(s.left, t.left) && process(s.right, t.right);

    }

    public static void main(String[] args){

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);

        System.out.println(isSubtree(s,t));

    }
}
