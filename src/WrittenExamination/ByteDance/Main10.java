package WrittenExamination.ByteDance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        List<Integer> ll =new ArrayList<>();
        for (int i = 0; i < len; i++){
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            int x = Integer.parseInt(strs[2]);
            int y = Integer.parseInt(strs[3]);
            ArrayList<Integer> list = new ArrayList<>();
            s = sc.nextLine();
            String[] ss = s.split(" ");
            for (int j = 0; j < ss.length; j++){
                list.add(Integer.parseInt(ss[j]));
            }
            ll.add(getTime(n,m,x,y,list));
        }

        for (int i = 0;i < ll.size(); i++){
            System.out.println(ll.get(i));
        }
    }

    public static int getTime(int n, int m, int x, int y,ArrayList<Integer> list){
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return Math.max(x,y)+ list.get(0);
    }

}
