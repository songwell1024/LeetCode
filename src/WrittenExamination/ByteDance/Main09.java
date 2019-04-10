package WrittenExamination.ByteDance;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<List<Integer>> lists = new LinkedList<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();  //读取每一行
            String[] num = s.split(",");
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i< num.length; i++){
                list.add(Integer.parseInt(num[i]));
            }
            lists.add(list);
        }

        int help = 0;
        List<Integer> res = new ArrayList<>();
        int n = 0;

        while (help < lists.size()){
            if (n == lists.size()){
                n = 0;
            }
            List<Integer> list = lists.get(n);
            n++;
            if ( list.size() == 0){
                continue;
            }

            for (int j = 0; j< len && list.size() > 0; j++){
                res.add(list.get(0));
                list.remove(0);
            }
            if (list.size() == 0){
                help++;
            }
        }
        for (int i = 0; i < res.size(); i++){
            System.out.print(res.get(i));
            if (i < res.size() -1){
                System.out.print(",");
            }
        }
    }
}
