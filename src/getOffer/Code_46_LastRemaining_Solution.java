package getOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program:
 * @description:
 * 圆圈中最后剩下的数
 * @author: Song
 * @create: Created in 2019-03-23 15:33
 * @Modified by:
 **/
public class Code_46_LastRemaining_Solution {
    private static class Node {
        Node next;
        int val;

        public Node(int val){
            this.val  =val;
        }
    }
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0 && m == 0){
            return -1;
        }

        Node root =  new Node(0);
        Node cur = root;
        for (int i = 1; i < n; i ++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = root;
        cur = root;

        while (cur.next.val != cur.val){
            for (int i = 1; i < m-1; i++){
                cur = cur.next;
            }
            Node node = cur.next;
            cur.next = node.next;
            node = null;
            cur = cur.next;
        }
        return cur.val;

    }



    public class Solution {
        //bt相当于当前开始的人的序号，从bt开始往后数m-1个人，这个就是该淘汰的人。下一此开始的人为上一次淘汰的人的下一个，上次remove应该返回的就是上一次淘汰的人的下一个人。
        //%list.size()就相当于最后一个小朋友报完数了，再从第一个小朋友开始报数。
        //f[i]=(f[i-1]+m)%i;  (i>1)
        public int LastRemaining_Solution(int n, int m) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < n; i ++) {
                list.add(i);
            }

            int bt = 0;
            while (list.size() > 1) {
                bt = (bt + m - 1) % list.size();
                list.remove(bt);
            }

            return list.size() == 1 ? list.get(0) : -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
    }

}
