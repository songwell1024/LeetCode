package WrittenExamination.Wangyi;

import java.util.Scanner;

/**
 * @ClassName: main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 15:57
 * @Version 1.0
 **/
public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i< n;i++){
            long A = sc.nextLong();
            long B = sc.nextLong();
            long p = sc.nextLong();
            long q = sc.nextLong();
            System.out.println(process(A, B, p,q)+1);
        }
    }
    public static  int process(long A, long B, long p, long q){
        if (B <= A){
            return 0;
        }
        if (B> (A +p)){
            return Math.min(process(A+ p,B, p, q)+1,process(A,B, p * q, q)+1);
        }
        return 0;
    }
}
