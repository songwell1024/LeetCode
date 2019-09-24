package WrittenExamination.Zoom;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/17 14:58
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1025];
        dp[n]  = 0;
        for (int i = n+1; i <= 1024; i++){
            if (i-64>=n){
                dp[i] = dp[i-64] + 1;
            }else if (i-16>=n){
                dp[i] = dp[i-16] + 1;
            }else if (i-4 >=n){
                dp[i] = dp[i-4] + 1;
            }else {
                dp[i] = dp[i-1] + 1;
            }
        }
        System.out.println(dp[dp.length-1]);

    }


}
