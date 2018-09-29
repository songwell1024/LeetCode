package Easy;

/**
 * 判断两个树是否相同
 * @author WilsonSong
 * @date 2018/9/28/028
 */
public class SameTree {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
      public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
          return true;
        }else if(p!= null && q!=null){
            if (p.val != q.val){
                return false;
            }
        }else {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      }



      public static void main(String[] args){
          TreeNode p = new TreeNode(1);
          p.left = new TreeNode(1);
          p.right = new TreeNode(2);
          p.left.left = null;
          p.left.right = new TreeNode(3);


          TreeNode q = new TreeNode(1);
          q.left = new TreeNode(1);
          q.right = new TreeNode(2);
//          q.left.left = null;
//          q.left.right = new TreeNode(3);

          System.out.println(isSameTree(p,q));

      }
}
