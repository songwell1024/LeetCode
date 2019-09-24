package WrittenExamination.Aiqiyi;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @ClassName: Main22
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/8 16:05
 * @Version 1.0
 **/
public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(new DecimalFormat("0.00000").format(getNum(n,m, n+m)));

    }
    public static double getNum(int n, int m,int sum){
        if (sum == 0){
            return 0.0;
        }
        return ((double) n/sum )+
                ((double) m/sum) *((double) (m-1)/(sum-1)) * ((double) (n)/(sum-2))*getNum(n-1,m-2,sum-3) //110
                +((double) m/sum) *((double) (m-1)/(sum-1)) * ((double) (m-2)/(sum-2))*getNum(n,m-3,sum-3);  //111
    }
}
