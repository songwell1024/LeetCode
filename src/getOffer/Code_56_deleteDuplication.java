package getOffer;

/**
 * @program:
 * @description:
 * 删除链表中重复的节点
 * @author: Song
 * @create: Created in 2019-03-24 18:09
 * @Modified by:
 **/
public class Code_56_deleteDuplication {
     public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead) {
         if (pHead == null || pHead.next == null){
             return pHead;
         }
         boolean flag = false;
         while (pHead.next != null){
             if (pHead.val == pHead.next.val){
                 pHead = pHead.next;
                 flag = true;
             }else {
                 if (flag){
                     pHead = pHead.next;
                     if (pHead.next !=null){
                         if (pHead.val != pHead.next.val){
                             flag = false;
                             break;
                         }
                     }
                     flag = false;
                 }else {
                     break;
                 }
             }
         }
         if (flag){
             pHead = pHead.next;
         }

         ListNode cur = pHead;
         ListNode pre = null;

         while (cur != null && cur.next != null){
             if (cur.val == cur.next.val){
                if (pre != null){
                    pre.next = cur.next.next;
                    cur = cur.next.next;
                }
             }else {
                 pre = cur;
                 cur = cur.next;
             }
         }
         return pHead;
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication2(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication2(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next= new ListNode(1);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next.next = new ListNode(5);
        deleteDuplication(node);
    }
}
