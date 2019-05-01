package medium;

/**
 * @program: LeetCode
 * @description:
 * 删除链表中的倒数第K个元素
 * 快指针慢指针，然后看他是再从头来还是从中间往后走
 * Could you do this in one pass?
 * @author: Song
 * @create: 2019-05-01 15:35
 **/
public class Code_19_RemoveNthNodeFromEndOfList {
     public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
     //我这个不算一边就整理完
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0){
            return head;
        }
        if (head.next == null && n == 1){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int index = 1;
        while (fast != null && fast.next != null){
            slow = slow.next;
            if (fast.next != null){
                fast =fast.next;
                index++;
            }else {
                break;
            }
            if (fast.next != null){
                fast = fast.next;
                index ++;
            }else {
                break;
            }

        }

        int mid = index % 2 == 0 ? index /2 : index / 2 + 1;
        if (n >= mid){
            n = index -n;
            if (n == 0){
                head = head.next;
            }else {
                ListNode cur = head;
                while (n > 1){
                    cur = cur.next;
                    n -- ;
                }
                ListNode help = (cur.next == null ? null : cur.next.next);
                cur.next = null;
                cur.next = help;
            }
        }else {
            n = mid - n;
            while (n > 1){
                slow = slow.next;
                n--;
            }
            ListNode help = (slow.next == null ? null : slow.next.next);
            slow.next = null;
            slow.next = help;
        }
        return head;
    }

    //一遍执行完
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while(n>1) {
            fast = fast.next;
            n--;
        }
        ListNode prev = null;
        while(fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(prev != null)
            prev.next = slow.next; //delete slow by pointing prev next to slow next
        return prev == null ? head.next : head; //handle first element delete i.e. prev is null
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        removeNthFromEnd(head,1);
    }

}
