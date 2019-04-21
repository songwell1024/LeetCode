package WrittenExamination.JD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/13 19:42
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m =Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<>();

        String s;
        while (sc.hasNextLine()){
            s = sc.nextLine();
            list.add(s);
        }
        String T  = list.get(list.size() -1);
        list.remove(list.size() -1);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int res = 0;
        String finStr;
        String[] resArr = new String[2];
        for (int i = 0; i< list.size(); i++){
            resArr = filter(T,list.get(i));
            res += Integer.parseInt(resArr[0]);
            T = resArr[1];
        }
        System.out.println(res);
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
