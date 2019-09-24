package WrittenExamination.dajiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/4 19:35
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        int n = Integer.parseInt(str1.split(" ")[0]);  //bug总数
        int p = Integer.parseInt(str1.split(" ")[1]);  //倍数
        int c = Integer.parseInt(str1.split(" ")[2]);  //咖啡数
        int[][] arrp = new int[p][3];
        for (int i = 0;  i < p; i++){
            String str2 = sc.nextLine();
            arrp[i][0] = Integer.parseInt(str1.split(" ")[0]);  //bug总数
            arrp[i][1] = Integer.parseInt(str1.split(" ")[1]);  //倍数
            arrp[i][2] = Integer.parseInt(str1.split(" ")[2]);  //咖啡数
        }

}


}
