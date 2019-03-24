package getOffer;

/**
 * @program:
 * @description:
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author: Song
 * @create: Created in 2019-03-24 17:52
 * @Modified by:
 **/
public class Code_55_EntryNodeOfLoop {

     public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        fast = pHead;
        while (fast.next != null ){
            if (fast ==  slow){
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }

}
