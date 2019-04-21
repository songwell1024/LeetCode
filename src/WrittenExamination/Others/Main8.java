package WrittenExamination.Others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        ArrayList<String> listNC = new ArrayList<>();
        ArrayList<String> listC = new ArrayList<>();
        ArrayList<String> listMove = new ArrayList<>();
        ArrayList<String> lisCom = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();  //读取每一行
            if (isVaild(s)){
                if (!listNC.contains(s)){
                    listNC.add(s);
                }
            }else {
                if (s.length() != 0 || s != null){
                    listC.add(s);
                }
            }
        }

        for (int i = 0; i < listNC.size(); i++){
            listMove.add(move(listNC.get(i)));
            lisCom.add(move(listNC.get(i)));
        }
        lisCom.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < listNC.size(); i++){
            System.out.print(listNC.get(i)+" ");
        }
        System.out.println();

        for (int i = 0; i < listC.size(); i++){
            System.out.print(listC.get(i)+" ");
        }
        System.out.println();

        for (int i = 0; i < listMove.size(); i++){
            System.out.print(listMove.get(i)+" ");
        }
        System.out.println();
        lisCom.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < lisCom.size(); i++){
            System.out.print(lisCom.get(i)+" ");
        }

    }

    public static boolean isVaild(String s){
        if (s == null || s.length() == 0){
            return false;
        }
        for (int i = 0; i< s.length(); i++){
            if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9')
            || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))){
                return false;
            }
        }
        return true;
    }

    public static String move(String s){
        StringBuilder str = new StringBuilder();
        int index = 10 % s.length();
        for (int i = index; i < s.length(); i++){
            str.append(s.charAt(i));
        }
        for (int i = 0; i < index; i++){
            str.append(s.charAt(i));
        }
        return str.toString();
    }

}
