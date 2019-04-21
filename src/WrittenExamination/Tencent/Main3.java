package WrittenExamination.Tencent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/13 20:40
 * @Version 1.0
 **/
public class Main3 {

    public static class Node{
        int val;
        String string;
        Node node;
        public Node(int val,String string){
            this.val =val;
            this.string = string;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m =Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<>();

//        String s;
//        while (sc.hasNextLine()){
//            s = sc.nextLine();
//            list.add(s);
//        }
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("aabbbbbbccc");
        String T  = list.get(list.size() -1);
        list.remove(list.size() -1);
        ArrayList<Node> list1 = new ArrayList<>();
        for (int i = 0; i< list.size(); i++){
            int count = getNumInString(T, list.get(i));
            list1.add(new Node(count, list.get(i)));
        }

        list1.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (o2.val - o1.val) & (o1.string.length() - o2.string.length());
            }
        });
        int res = 0;
        String[] resArr = new String[2];
        for (int i = 0; i< list1.size(); i++){
            resArr = filter(T, list1.get(i).string);
            res += Integer.parseInt(resArr[0]);
            T = resArr[1];
        }
        System.out.println(res);
    }

    public static int getNumInString(String s,String sub){
        int old_length=s.length();
        String replace="";
        if (s.contains(sub)){
            replace = s.replace(sub, "");
        }
        int new_length= replace.length();
        int count=(old_length-new_length)/(sub.length());
        return count;
    }


    public static String[] filter(String s,String sub){
        int old_length=s.length();
        String replace="";
        if (s.contains(sub)){
            replace = s.replace(sub, "");
        }
        int new_length= replace.length();
        int count=(old_length-new_length)/(sub.length());
        return new String[]{
                String.valueOf(count), replace
        };
    }
}
