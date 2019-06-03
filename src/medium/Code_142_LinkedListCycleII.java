package medium;

/**
 * @program: LeetCode
 * @description:
 * 给定链表，返回循环开始的节点。如果没有循环，则返回null。
 *
 * 为了表示给定链表中的循环，我们使用一个整数pos来表示tail连接到的链表中的位置（0索引）。如果pos是-1，那么链表中没有循环。
 * @author: Song
 * @create: 2019-06-03 19:37
 **/
public class Code_142_LinkedListCycleII {
    private static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public  static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null){
            if (fast != slow){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                break;
            }
        }

        if (fast != slow){
            return null;
        }else {
            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow  = slow.next;
            }
            return fast;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = head.next;
        detectCycle(head);
    }
}
