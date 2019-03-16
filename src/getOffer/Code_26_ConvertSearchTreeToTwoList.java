package getOffer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program:
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: Song
 * @create: Created in 2019-03-15 16:53
 * @Modified by:
 **/
public class Code_26_ConvertSearchTreeToTwoList<K> {
     public static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }

     }

    public static TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree==null)
                return null;
            if(pRootOfTree.left==null&&pRootOfTree.right==null)
                return pRootOfTree;
            // 1.将左子树构造成双链表，并返回链表头节点
            TreeNode left = Convert(pRootOfTree.left);
            TreeNode node = left;
            // 2.定位至左子树双链表最后一个节点
            while(node!=null&&node.right!=null){
                node = node.right;
            }
            // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
            if(left!=null){
                node.right = pRootOfTree;
                pRootOfTree.left = node;
            }
            // 4.将右子树构造成双链表，并返回链表头节点
            TreeNode right = Convert(pRootOfTree.right);
            // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
            if(right!=null){
                right.left = pRootOfTree;
                pRootOfTree.right = right;
            }
            if (left!= null){
                return left;
            }
            return pRootOfTree;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        Convert(node);
        HashMap map = new ConcurrentHashMap<>()
    }

}
