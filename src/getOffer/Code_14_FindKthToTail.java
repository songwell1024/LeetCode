package getOffer;

/**
 * @program:
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 * 双指针
 * @author: Song
 * @create: Created in 2019-03-13 16:31
 * @Modified by:
 **/
public class Code_14_FindKthToTail {

public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0){
            return null;
        }
        if (head.next == null && k ==1){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int length = 1;
        int sl = 1;
        while (fast != null &&fast.next != null){
            length += 2;
            sl++;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null){
            length --;
        }
        if (length < k){
            return null;
        }
        if (sl < (length - k + 1)){
            while (sl < (length - k + 1)){
                slow = slow.next;
                sl++;
            }
            return slow;
        }else {
            slow = head;
            sl = 1;
            while (sl < (length - k + 1)){
                slow = slow.next;
                sl++;
            }
            return slow;

        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        FindKthToTail(node,1);

    }

}
