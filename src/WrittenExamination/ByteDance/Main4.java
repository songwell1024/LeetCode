package WrittenExamination.ByteDance;

import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/14 11:45
 * @Version 1.0
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] num = new int[n][n];
        for (int i = 0; i< n; i++){
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            for (int j = 0; j< n; j++){
                if (Integer.parseInt(strs[j]) == 0){
                    num[i][j] = Integer.MAX_VALUE;
                }else {
                    num[i][j] = Integer.parseInt(strs[j]);
                }
            }
        }

        System.out.print(minPathSum(num));
    }

    public static int minPathSum(int [][] m) {

        if(m==null || m.length==0 || m[0]==null || m[0].length ==0) {
            return 0;
        }

        int row=m.length;
        int col=m[0].length;
        int[][] dp=new int[row][col];
        dp[0][0] = m[0][0];

        for(int i=1;i<row;i++) {
            dp[i][0] = dp[i-1][0]+m[i][0];
        }

        for(int j=1;j<col;j++) {
            dp[0][j] = dp[0][j-1]+m[0][j];
        }

        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
            }
        }

        return dp[row-1][col-1];
    }
}
