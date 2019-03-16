package getOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 从尾到头打印链表
 * @author: Song
 * @create: Created in 2019-03-11 15:00
 * @Modified by:
 **/
public class Code_03_PrintListFromTailToHead {
    private class ListNode{
        ListNode next;
        int val;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        process(list, listNode);
        return list;
    }

    public void process(ArrayList<Integer> list, ListNode node){
        if (node == null){
            return;
        }
        process(list, node.next);
        list.add(node.val);
    }
}
