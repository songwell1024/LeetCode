package WrittenExamination.TencentQiuZhao;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/1 20:12
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] boxs = new int[n];
        long sum = 0;
        for (int i = 0; i< n; i++){
            boxs[i] = sc.nextInt();
            sum += boxs[i];
        }
        if (sum <= m){
            System.out.println(n+1);
            return;
        }
        long res = 1;
        int index = 0;

        while (index < n){
            int help = m;
            while (index < n && help >= boxs[index]){
                help -= boxs[index];
                index++;
                res++;
            }
            if (index < n && boxs[index] > help){
                boxs[index] -= help;
                res++;
            }
        }
        System.out.println(res);
    }
}
