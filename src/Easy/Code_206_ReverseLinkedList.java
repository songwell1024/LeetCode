package Easy;

/**
 * 反转链表
 * @author WilsonSong
 * @date 2019/1/4/004
 */
public class Code_206_ReverseLinkedList {
    public class Node{
        Node next;
        int value;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    public Node reverseList(Node head) {

        if (head == null){
            return null;
        }
        Node pre = null;

        while (head != null){
            Node curNext = head.next;
            head.next = pre;
            pre = head;
            head = curNext;
        }
        return pre;


    }


}
