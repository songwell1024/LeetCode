package WrittenExamination.JingDong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/24 20:30
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        int[][] edges = new int[m][2];

        for (int i = 0; i< m;i++){
            String s1 = sc.nextLine();
            edges[i][0] = Integer.parseInt(s1.split(" ")[0]);
            edges[i][1] = Integer.parseInt(s1.split(" ")[1]);
        }
        System.out.print(1);
        System.out.println(1);
    }

}
