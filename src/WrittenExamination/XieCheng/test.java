package WrittenExamination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/4 19:35
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str1 = sc.nextLine();
            int n = Integer.parseInt(str1.split(" ")[0]);  //bug总数
            int A = Integer.parseInt(str1.split(" ")[1]);  //倍数
            int x = Integer.parseInt(str1.split(" ")[2]);  //咖啡数
            if (n< 0 || n > 8 || A <=0 || A > 8 || x < 0 || x > 8){
                System.out.println(0);
            }
            String str2 = sc.nextLine();
            String[] strings = str2.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(arr);
            int[] bug = new int[n];
            int allTime = 0;
            for (int i = 0; i< n; i++){
                bug[n-i-1] = arr[i];
                allTime += arr[i];
            }
            int res = 0;
            if (allTime <= x * 60 * A ){
                if (allTime % A == 0){
                    res = allTime /A;
                }else {
                    res = allTime /A +1;
                }
            }else {
                int time = x * 60 * A;
                for (int i = 0; i < bug.length; i++){
                    if (time - bug[i] >= 0){
                        if (bug[i] % A == 0){
                            res += bug[i] /A;
                        }else {
                            res += bug[i] /A + 1;
                        }
                        time -= bug[i];
                    }else {
                        res += bug[i];
                    }
                }
            }
            if (res > 480){
                System.out.println(0);
            }else {
                System.out.println(res);
            }
        }
    }
}
