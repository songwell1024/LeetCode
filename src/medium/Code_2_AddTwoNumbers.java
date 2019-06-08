package medium;

/**
 * @ClassName: Code_2_AddTwoNumbers
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/6/8 14:46
 * @Version 1.0
 **/
public class Code_2_AddTwoNumbers {
    private static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }
        ListNode pre = null;
        while (head != null){
            ListNode help = head.next;
            head.next = pre;
            pre = head;
            head = help;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);

    }
}
