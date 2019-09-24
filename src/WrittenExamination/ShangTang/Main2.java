package WrittenExamination.ShangTang;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 20:04
 * @Version 1.0
 **/
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                max = Math.max(max, search(arr, dp, n, i, j));
            }
        }
        System.out.println(max);
    }

    private static int search(int[] arr, int[][] dp, int n, int i, int j){
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        if (i == j){
            dp[i][j] = arr[i];
        } else if (i == 0){
            dp[i][j] = arr[j] + search(arr, dp, n, i, j-1);
        } else if (i < j){
            dp[i][j] = search(arr, dp, n, 0, j) - search(arr, dp, n, 0, i-1);
        } else {
            dp[i][j] = search(arr, dp, n, i, n-1) + search(arr, dp, n, 0, j);
        }
        return dp[i][j];
    }
}
