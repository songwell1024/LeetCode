package WrittenExamination.ViVO;
import java.io.*;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/22 16:24
 * @Version 1.0
 **/
public class Main3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    private static int solution1(int[] input) {

        String s = new String();
        StringBuilder sb = new StringBuilder();
        return 0;
    }
    private static int solution(int[] input) {

        return getTwoSubArrayMinDiff(input);
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
