package WrittenExamination.dongfangcaifu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/6 19:09
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< day; i++){
            list.add(Integer.parseInt(s.split(" ")[i]));
        }
        int max = 0;
        for (int i = 1; i< list.size(); i++){
            max = Math.max(max, list.get(i) - list.get(i-1));
        }
        int max2 = 0;
        for (int i =  1; i < list.size(); i++){

            if (list.get(i)- list.get(i-1) != max){
             max2 = Math.max(max2,list.get(i)-list.get(i-1));
            }
        }
        System.out.println(max +max2);
    }
}
