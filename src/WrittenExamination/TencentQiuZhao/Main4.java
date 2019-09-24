package WrittenExamination.TencentQiuZhao;

import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/1 21:41
 * @Version 1.0
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] socre = new int[n];
        for (int i = 0; i< n;i++){
            socre[i] = sc.nextInt();
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i< n; i++){
            long min = Integer.MAX_VALUE;
            long sum= 0;
            for (int j = i; j < n; j++){
                sum += socre[j];
                min = Math.min(min, socre[j]);
                max = Math.max(max, sum * min);
            }
        }
        System.out.println(max);
    }
}
