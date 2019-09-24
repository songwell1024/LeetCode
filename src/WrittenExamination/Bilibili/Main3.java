package WrittenExamination.Bilibili;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/20 19:59
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] W = new int[N];
        for (int i = 0; i< N; i++){
            W[i] = sc.nextInt();
        }
        int[] V = new int[N];
        for (int i = 0; i< N; i++){
            V[i] = sc.nextInt();
        }
        int[][] maxValue = new int[N+1][M+1];
        for (int j = 1; j<=M; j++){
            for (int i = 1; i<=N; i++){
                if (j<W[i-1]){
                    maxValue[i][j] = maxValue[i-1][j];
                }else {
                    maxValue[i][j] = Math.max(maxValue[i-1][j], maxValue[i-1][j-W[i-1]]+V[i-1]);
                }
            }
        }
        System.out.println(maxValue[N][M]);
    }

}
