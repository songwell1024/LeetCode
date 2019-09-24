package WrittenExamination.Zoom;


import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/17 14:36
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strings = (sc.nextLine().split(","));
        double[] arr = new double[strings.length];
        for(int i = 0; i< arr.length; i++){
            arr[i] = Double.valueOf( strings[i]);
        }
        if (arr.length == 0){
            System.out.println(-1);
        }
        double[] dp = new double[arr.length];
        double min = arr[0];
        double max = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i< dp.length; i++){
            if (arr[i] < 0){
                double help = max;
                max = min;
                min = help;
            }
            max =Math.max(arr[i], arr[i] * max);
            min = Math.min(arr[i], arr[i] * min);
            dp[i] = Math.max(dp[i-1], max);
        }
        System.out.println(dp[dp.length-1]);
    }


}
