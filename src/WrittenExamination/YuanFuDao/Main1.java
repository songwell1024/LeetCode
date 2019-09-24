package WrittenExamination.YuanFuDao;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 17:33
 * @Version 1.0
 **/
public class Main1 {

    /**
     * @ClassName: Main1
     * @Description:
     * @Author: WilsonSong
     * @Date: 2019/9/16 17:33
     * @Version 1.0
     **/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == 1){
                for (int i =0; i< M; i++){
                    System.out.print( sc.nextInt());
                    System.out.print(" ");
                }
            }
            if (M == 1){
                for (int i =0; i< N; i++){
                    System.out.print( sc.nextInt());
                    System.out.print(" ");
                }
            }
            int[][] arr = new int[N][M];
            for (int i = 0; i< N;i++){
                for (int j = 0; j<M; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            if (arr == null || N <=0 || M <= 0){
                return;
            }
            Solution01(arr, N, M);
        }

        public static void Solution01(int[][] arr, int n, int m) {
            int startX = 0;
            int startY = 0;
            int endX = m-1;
            int endY = n-1;
//            int index = 0;
//            int[] res = new int[n*m];
            while (startX <= endX && startY <= endY) {
                // 上---->下
                if (startY <= endY) {
                    for (int i = startY; i <= endY; i++) {
                        System.out.print(arr[i][startX]);
                        System.out.print(" ");
                    }
                }
                // 左---->右 (两列以上)
                if (startX < endX) {
                    for (int i = startX+1; i <= endX; i++) {
                        System.out.print( arr[endY][i]);
                        System.out.print(" ");
                    }
                }
                // 下---->上(两行两列以上)
                if (startX < endX && startY < endY) {
                    for (int i = endY-1; i >= startY; i--) {
                        System.out.print( arr[i][endX]);
                        System.out.print(" ");
                    }
                }
                // 右---->左(三列两行以上)
                if (startX < endX-1 && startY < endY) {
                    for (int i = endX-1; i >= startX+1; i--) {
                        System.out.print( arr[startY][i]);
                        System.out.print(" ");
                    }
                }
                startX++;
                startY++;
                endX--;
                endY--;
            }
//            return res;
        }
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M =sc.nextInt();
//        int[][] arr = new int[N][M];
//        for (int i = 0; i< N;i++){
//            for (int j = 0; j<M; j++){
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        int[] res = Solution01(arr, N, M);
//        for (int i : res) {
//            System.out.print(i);
//            System.out.print(" ");
//        }
//    }
//
//    public static int[] Solution01(int[][] arr, int n, int m) {
//        int startX = 0;
//        int startY = 0;
//        int endX = m-1;
//        int endY = n-1;
//        int index = 0;
//        int[] res = new int[n*m];
//        while (startX <= endX && startY <= endY) {
//            // 上---->下
//            if (startY <= endY) {
//                for (int i = startY; i <= endY; i++) {
//                    res[index++] = arr[i][startX];
//                }
//            }
//            // 左---->右 (两列以上)
//            if (startX < endX) {
//                for (int i = startX+1; i <= endX; i++) {
//                    res[index++] = arr[endY][i];
//                }
//            }
//            // 下---->上(两行两列以上)
//            if (startX < endX && startY < endY) {
//                for (int i = endY-1; i >= startY; i--) {
//                    res[index++] = arr[i][endX];
//                }
//            }
//            // 右---->左(三列两行以上)
//            if (startX < endX-1 && startY < endY) {
//                for (int i = endX-1; i >= startX+1; i--) {
//                    res[index++] = arr[startY][i];
//                }
//            }
//            startX++;
//            startY++;
//            endX--;
//            endY--;
//        }
//        return res;
//    }
//}
