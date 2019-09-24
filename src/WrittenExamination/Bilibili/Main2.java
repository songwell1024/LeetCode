package WrittenExamination.Bilibili;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/20 19:43
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(",");
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo((o2+o1));
            }
        });
        StringBuilder res = new StringBuilder();
        for(String s : str){
            res.append(s);
        }
        System.out.println(res.toString());
    }
}
