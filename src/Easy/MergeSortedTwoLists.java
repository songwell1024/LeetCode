package Easy;

/**
 * 融合两个排序链表
 * @author WilsonSong
 * @date 2018/9/23/023
 */
public class MergeSortedTwoLists {
     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
         ListNode(){
         }
      }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode head = null;
         if (l1 == null){
             head = l2;
             return head;
         }
         if (l2 == null){
             head = l1;
             return head;
         }
         if (l1 != null && l2 != null){
             if (l1.val > l2.val){
                 head  = new ListNode(l2.val);
                 l2 = l2.next;
             }else {
                 head = new ListNode(l1.val);
                 l1 = l1.next;
             }
         }
         ListNode cur = head;

         while (l1 != null ||  l2 != null){
             if (l1 == null){
                 head.next = l2;
                 l2  = l2.next;
                 head  = head.next;
             }else if (l2 == null){
                 head.next = l1;
                 l1 = l1.next;
                 head  =head.next;
             }else {
                 if (l1.val > l2.val){
                     head.next  = l2;
                     l2 = l2.next;
                     head  =head.next;
                 }else {
                     head.next = l1;
                     l1 = l1.next;
                     head  =head.next;
                 }
             }
         }
         return cur;
    }

    public static void main(String[] args){

//        ListNode list1 = new ListNode(1);
//        list1.next = new ListNode(2);
//        list1.next.next = new ListNode(4);
//        list1.next.next.next = new ListNode(6);

        ListNode list1 = new ListNode(2);;
        ListNode list2 = new ListNode(1);
//        list2.next = new ListNode(3);
//        list2.next.next = new ListNode(4);


        mergeTwoLists(list1,list2);


    }


}
