package WrittenExamination.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/10 19:17
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n <= 1){
            System.out.println(0);
            return;
        }
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        if (n ==2 && (double)w[0] >= (w[1]*0.9)){
            System.out.println(1);
            return;
        }
        Arrays.sort(w);
        int res = 0;
//        int l = 0;
//        int r = 1;
//        while (r < n){
//            if ((double)w[l] >= (w[r] * 0.9)){
//                r ++;
//            }else {
//                if (r - l >= 1){
//                    int help = r - l;
//                    res += help;
////                    res += ((help * (help -1)) /2);
//                    l ++;
//                    if (l == r){
//                        r ++;
//                    }
//                }else {
//                    l ++;
//                    if (l == r){
//                        r ++;
//                    }
//                }
//            }
//        }
//        if (r - l >= 1){
//            int help = r - l;
////            res += ((help * (help -1)) /2);
//            res += help;
//        }
        for (int i = 0; i< n-1; i++){
            for (int j = i+ 1; j <n; j++ ){
                if ((double) w[i] >= (w[j] * 0.9)){
                    res++;
                }else {
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
