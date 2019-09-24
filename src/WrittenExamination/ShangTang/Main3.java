package WrittenExamination.ShangTang;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 19:50
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        long n = Long.valueOf(str.split(" ")[0]);
        String x = str.split(" ")[1];
        long index = 10;
        for (;;index++){
            if (string10ToN(x, index) == n){
                System.out.println(index);
                return;
            }
        }
    }
    public static long string10ToN(String s, long radix) {
        long res = 0;
        double help = (double) radix;
        for (int i=s.length()-1; i>0;i--){
            double x = (double)(s.charAt(i) - '0');
            res+= (x * Math.pow(s.length()-1 - i, help));
        }
        return res;
    }
}
