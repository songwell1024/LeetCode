package medium;

/**
 * @program: LeetCode
 * @description:
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 方法是使用的二分加归并的方法，时间复杂度是o(nlogn),空间复杂度0（n）
 * @author: Song
 * @create: 2019-04-29 15:36
 **/
public class Code_148_SortList {
    public static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;

        int length = 0;
        while (cur != null){
            cur = cur.next;
            length ++;
        }

        length = length /2;
        cur = head;
        ListNode pre = null;
        while (length >= 0 && cur.next != null){
            pre = cur;
            length --;
            cur = cur.next;
        }
        pre.next = null;
        ListNode head1 = head;
        ListNode help1 = sortList(head1);
        ListNode help2  = sortList(cur);
        return merge(help1, help2);
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode res;
        if (left.val <= right.val){
            res = left;
            left = left.next;
        }else {
            res = right;
            right = right.next;
        }
        ListNode cur = res;
        while (left != null && right != null){
            if (left.val <= right.val){
                cur.next = left;
                left = left.next;
                cur = cur.next;
            }else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }

        while (left != null){
            cur.next = left;
            cur = cur.next;
            left = left.next;
        }

        while (right!= null){
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }
        return res;
    }


    /**
    *@Description:  时间复杂度o(nlogn),空间复杂度o(1)\
    *@Param:
    *@return: 
    *@Author: Song
    *@date: 2019/4/29
    */
    public static ListNode sortList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode [] list = new ListNode[2];
        boolean done = (null == head);
        // Keep partitioning our list into bigger sublists length. Starting with a size of 1 and doubling each time
        for (int step = 1; !done; step *= 2) {
            done = true;
            ListNode prev = dummy;
            ListNode remaining = prev.next;
            do {
                // Split off two sublists of size step
                for (int i = 0; i < 2; ++i) {
                    list[i] = remaining;
                    ListNode tail = null;
                    for (int j = 0; j < step && null != remaining; ++j, remaining = remaining.next) {
                        tail = remaining;
                    }
                    // Terminate our sublist
                    if (null != tail) {
                        tail.next = null;
                    }
                }

                // We're done if these are the first two sublists in this pass and they
                // encompass the entire primary list
                done &= (null == remaining);

                // If we have two sublists, merge them into one
                if (null != list[1]) {
                    while (null != list[0] || null != list[1]) {
                        int idx = (null == list[1] || null != list[0] && list[0].val <= list[1].val) ? 0 : 1;
                        prev.next = list[idx];
                        list[idx] = list[idx].next;
                        prev = prev.next;
                    }

                    // Terminate our new sublist
                    prev.next = null;
                } else {
                    // Only a single sublist, no need to merge, just attach to the end
                    prev.next = list[0];
                }
            } while (null != remaining);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        sortList2(head);
        System.out.println(head);
    }


}
