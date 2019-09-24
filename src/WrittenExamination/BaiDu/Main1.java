package WrittenExamination.BaiDu;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/24 18:53
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long max = Integer.MIN_VALUE;
        for (int i  = 1; i<= n; i++){
            for (int j = 1; j<= n; j++){
                long gcd = getGCD(i,j);
                max = Math.max(i * j / gcd - gcd, max );
            }
        }
        System.out.println(max);
    }
    public static long getGCD(long num1, long num2){
        if (num1 == 0){
            return num2;
        }
        if (num2 == 0){
            return num1;
        }
        if (num1 % 2 == 0 && num2 % 2 == 0){
            return 2 * getGCD(num1/2 , num2 /2);
        }else if (num1 % 2 == 0){
            return getGCD(num1/2 , num2);
        }else if (num2 % 2 == 0){
            return getGCD(num1 , num2/2);
        }else {
            long min = num1 > num2 ? num2 : num1;
            return getGCD(Math.abs(num1 - num2), min);
        }
    }
}
