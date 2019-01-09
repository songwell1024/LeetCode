package Easy;

/**
 * 没有环的链表的交点
 * @author WilsonSong
 * @date 2019/1/9/009
 */
public class Code_160IntersectionOfTwoLinkedLists {
    public class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int L = 0;
        ListNode cur = headA;
        while (cur != null){
            L++;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null){
            L--;
            cur = cur.next;
        }

        ListNode fast = null;
        ListNode slow = null;
        if (L > 0){
            fast = headA;
            slow = headB;
        }else {
            fast = headB;
            slow = headA;
            L = -L;
        }
        while (L > 0){
            fast =fast.next;
            L--;
        }
        while (fast != null && slow != null){
            if (fast == slow){
                return fast;
            }
            fast = fast.next;
            slow =slow.next;
        }
        return null;
    }
}
