package Easy;

/**
 * @author WilsonSong
 * @date 2018/9/27/027
 */
public class RemoveDuplicatesFromSortedList {

    private static class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode cur = head;

        while (cur.next!= null){
            if (cur.value ==cur.next.value){
                if (cur.next.next != null){
                    cur.next  =cur.next.next;
                }else {
                    cur.next = null;
                }
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String args){

        ListNode node  =new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);



    }


}
