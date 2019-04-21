package WrittenExamination.Others;

import java.util.ArrayList;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()){
            String s = in.nextLine();  //读取每一行
            if (s.equals("None") || s.length() == 0){
                System.out.println("False");
                return;
            }
            String[] strs = s.split(",");
            for (String str: strs){
                if (str.equals("None")){
                    System.out.println("False");
                    return;
                }
                list.add(Integer.parseInt(str));
            }
        }
        for (int i = 0; (i*2 + 2) < list.size(); i++){
            if (list.get(i) > list.get(i * 2 + 1) && list.get(i) < list.get(i * 2 + 2)){
                if (!processRight(list.get(i),i * 2 + 2, list)){
                    System.out.println("False");
                    return;
                }
                if (!processLeft(list.get(i),i * 2 + 1, list)){
                    System.out.println("False");
                    return;
                }
            }else {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
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

