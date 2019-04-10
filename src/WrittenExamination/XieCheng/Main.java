package WrittenExamination.XieCheng;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static class Node{
        Node next;
        int val;
         public Node(int val){
             this.val = val;
         }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        String[] strs = data.split(",");
        if (strs == null || strs.length == 0){
            System.out.println();
        }
        StringBuilder s1 = new StringBuilder();
        for (int i = 1; i< strs[0].length(); i++){
            s1.append(strs[0].charAt(i));
        }
        strs[0] = s1.toString();

        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i< strs[strs.length -1].length()-1; i++){
            s2.append(strs[strs.length -1].charAt(i));
        }
        strs[strs.length -1] = s2.toString();

        Node root = new Node(Integer.parseInt(strs[0]));
        Node cur = root;
        for (int i = 1; i < strs.length; i++){
            cur.next = new Node(Integer.parseInt(strs[i]));
            list.add(Integer.parseInt(strs[i]));
            cur = cur.next;
        }
        int k = Integer.parseInt(sc.nextLine());
        cur = root;
        if (k > 1){
            int index = 0;
            Node pre = null;
            Node helpNode = root;
            while (strs.length - index > k){
                while (index % k != 0){
                    Node node = cur.next;
                    cur.next =pre;
                    pre = cur;
                    cur = node;
                    index++;
                    if (index == k){
                        root = pre;
                    }
                }
                helpNode.next = cur;
                helpNode = helpNode.next;
                index++;
            }
        }
        System.out.print("[");
        while (root.next != null){
            System.out.print(root.val + ",");
            root = root.next;
        }
        System.out.print("]");
    }
}
