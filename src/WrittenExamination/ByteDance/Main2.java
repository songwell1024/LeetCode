package WrittenExamination.ByteDance;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/25 19:00
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = n/2;
        BigDecimal help = new BigDecimal( 1);
        BigDecimal res = new BigDecimal( 1);
        for (int i = 0; i< n; i++){
            BigDecimal b = new BigDecimal(2 * (2 * i + 1));
            res = help.multiply(b);
            res = res.divide(new BigDecimal(i+2));
            help = res;
        }
        BigDecimal bg = BigDecimal.valueOf(1000000007);
        res = (res.divideAndRemainder(bg)[1]);//取余
        System.out.println(res);
    }
}
