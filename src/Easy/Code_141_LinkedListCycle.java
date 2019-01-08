package Easy;

/**
 * 确定一个链表是否有环
 * 一个快的，一个慢的，快的走两步，慢的走一步有环总会相遇
 * @author WilsonSong
 * @date 2019/1/8/008
 */
public class Code_141_LinkedListCycle {

    public class ListNode{
        ListNode next;
        int val;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }


    }
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;


    }
}
