package Easy;

/**
 * 回文链表
 * @author WilsonSong
 * @date 2019/1/8/008
 */
public class Code_234_PalindromeLinkedList {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode cur = head;
        int size = 0;
        while (cur !=null){
            size ++;
            cur =cur.next;
        }
        int mid = size / 2;
        cur = head;
        for (int i = 0; i < mid; i++){
            cur = cur.next;
        }

        cur = reverse(cur);

        for (int i = 0; i < mid; i++){
            if (head.val != cur.val){
                return false;
            }
            head = head.next;
            cur = cur.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode node){

        ListNode pre = null;
        while (node != null){
            ListNode curNext = node.next;
            node.next = pre;
            pre = node;
            node = curNext;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(21);
        System.out.println(isPalindrome(head));

    }




}
