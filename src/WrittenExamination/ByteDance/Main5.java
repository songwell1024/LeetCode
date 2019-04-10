package WrittenExamination.ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();  //读取每一行
        if (s.equals("none")){
            System.out.println(true);
        }
        String[] strs = s.split(",");
        for (String str: strs){
            list.add(Integer.parseInt(str));
        }
        for (int i = 0; (i*2 + 2) < list.size(); i++){
            if (list.get(i) > list.get(i * 2 + 1) && list.get(i) < list.get(i * 2 + 2)){
                if (!processRight(list.get(i),i * 2 + 2, list)){
                    System.out.println(false);
                    return;
                }
                if (!processLeft(list.get(i),i * 2 + 1, list)){
                    System.out.println(false);
                    return;
                }
            }else {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static boolean processRight(int cur, int l, ArrayList<Integer> list){
        if (l >= list.size()){
            return true;
        }
        if (l * 2 + 2 < list.size() ) {
            if (cur < list.get(l * 2 + 1) && cur < list.get(l * 2 + 2)) {
                return processRight(cur, l * 2 + 1, list) &
                        processRight(cur, l * 2 + 2, list);
            } else {
                return false;
            }
        }{
            return true;
        }
    }

    public static boolean processLeft(int cur, int l, ArrayList<Integer> list){
        if (l >= list.size()){
            return true;
        }
        if (l * 2 + 2 < list.size() ) {
            if (cur > list.get(l * 2 + 1) && cur > list.get(l * 2 + 2)) {
                return processLeft(cur, l * 2 + 1, list) &
                        processLeft(cur, l * 2 + 2, list);
            } else {
                return false;
            }
        }{
            return true;
        }
    }
}
