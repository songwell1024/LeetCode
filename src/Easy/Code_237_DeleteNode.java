package Easy;

/**
 * 删除链表节点
 * @author WilsonSong
 * @date 2019/1/6/006
 */
public class Code_237_DeleteNode {
    public class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int value){
            this.value = value;
            this.next = null;
        }

    }

    public void deleteNode(ListNode node) {
        if (node == null){
            return;
        }
        ListNode pos = node.next;
        node.value = pos.value;
        node.next = pos.next;

    }

}
