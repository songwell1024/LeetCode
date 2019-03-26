package getOffer;

/**
 * @program:
 * @description:
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author: Song
 * @create: Created in 2019-03-25 15:36
 * @Modified by:
 **/
public class Code_57_GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
       if (pNode == null){
           return null;
       }
       if (pNode.right != null){
            if (pNode.right.left != null){
                pNode = pNode.right.left;
                while (pNode.left != null){
                    pNode = pNode.left;
                }
                return pNode;
            }else {
                return pNode.right;
            }
       }else {
           TreeLinkNode parent = pNode.next;
           if (parent != null){
               if (parent.left == pNode){
                   return parent;
               }else {
                   if (parent.next != null){
                       TreeLinkNode gParent = parent.next;
                       if (gParent.left ==  parent){
                           return gParent;
                       }else {
                           return null;
                       }
                   }else {
                       return parent;
                   }
               }
           }else {
               return parent;
           }

       }
    }
}
