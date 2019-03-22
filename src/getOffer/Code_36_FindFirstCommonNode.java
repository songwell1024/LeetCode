package getOffer;

/**
 * @program:
 * @description:
 * 输入两个链表，找出它们的第一个公共结点。
 * @author: Song
 * @create: Created in 2019-03-21 15:52
 * @Modified by:
 **/
public class Code_36_FindFirstCommonNode {
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode fast = pHead1;
        ListNode slow = pHead2;
        int index  =0;
        while (fast != null){
            index ++;
            fast =fast.next;
        }
        while (slow != null){
            slow = slow.next;
            index--;
        }
        fast = pHead1;
        slow = pHead2;

        if (index > 0){
            while (index > 0){
                fast = fast.next;
                index --;
            }
            while (fast != null && slow != null && fast.val != slow.val){
                fast = fast.next;
                slow = slow.next;
            }
            if (fast != null){
                return fast;
            }else {
                return null;
            }
        }else {
            while (index< 0){
                slow  =slow.next;
                index++;
            }
            while (fast != null && slow != null &&fast.val != slow.val){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }

}
