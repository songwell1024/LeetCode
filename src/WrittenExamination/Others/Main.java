package WrittenExamination.Others;

import java.util.Scanner;

public class Main {
    private static class Node {
        Node next;
        int val;

        public Node(int val){
            this.val  =val;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 0;
        int n = 0;
        n = in.nextInt();
        m = in.nextInt();
        if (n == 0 && m == 0){
            System.out.println(-1);
        }

        Node root =  new Node(1);
        Node cur = root;
        for (int i = 2; i <= n; i ++){
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = root;
        cur = root;
        int index = 1;
        int help = m;
        while (cur.next.val != cur.val && index != n){
            for (int i = 1; i < m-1; i++){
                cur = cur.next;
            }
            Node node = cur.next;
            cur.next = node.next;
            node = null;
            cur = cur.next;
            m *= help;
            index ++;
        }
        System.out.println( cur.val);
    }
}
