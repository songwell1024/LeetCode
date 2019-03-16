package getOffer;

import java.util.List;

/**
 * @program:
 * @description: 翻转链表
 * @author: Song
 * @create: Created in 2019-03-13 18:44
 * @Modified by:
 **/
public class Code_15_ReverseList {

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;

        while (head != null){
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
}
