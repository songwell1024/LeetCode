package WrittenExamination.ShangTang;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 19:30
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dp = new int[m][n];
        for (int i = 0; i< m;i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i<n;i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i< m;i++){
            for (int j = 1; j< n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
//        System.out.println(getMethodsNums(0,0,m,n));
        System.out.println(dp[m-1][n-1]);
    }

    public static int getMethodsNums(int start, int end,int m, int n){
        if (start == m && end == n){
            return 1;
        }
        if (start < m && end < n){
            return getMethodsNums(start +1, end,m, n) + getMethodsNums(start, end +1,m,n);
        }else if (start < m){
            return 1;
        }else if (end < n ){
            return 1;
        }else {
            return 0;
        }
    }
}
