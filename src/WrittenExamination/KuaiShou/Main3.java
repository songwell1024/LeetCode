package WrittenExamination.KuaiShou;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 21:52
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i< N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(getTwoSubArrayMinDiff(arr));
    }

    public static int getTwoSubArrayMinDiff(int[] arr){
        int sum = 0;
        for (int i = 0;i< arr.length; i++){
            sum+=arr[i];
        }
        int len = arr.length;
        int[][] dp = new int[len+1][sum/2+1];
        for (int i = 0; i< len; i++){
            for (int j = 1;j<= sum/2;j++){
                dp[i+1][j] = dp[i][j];
                if (arr[i]<=j && dp[i][j-arr[i]]+arr[i] > dp[i][j]){
                    dp[i+1][j] = dp[i][j-arr[i]]+arr[i];
                }
            }
        }
        return sum-2*dp[len][sum/2];
    }
}
