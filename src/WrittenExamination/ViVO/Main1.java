package WrittenExamination.ViVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/22 16:49
 * @Version 1.0
 **/
public class Main1 {

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

    private static int solution(int[] input) {
        if (input==null || input.length==0)
            return -1;
        int len = input.length;
        if (len==1)
            return 0;
        int[] dp = new int[len];
        for (int i = 1; i< dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i=0; i<len-1; i++){
            if (dp[i] == Integer.MAX_VALUE)
                continue;
            int distance = input[i];
            for (int j=1; j<=distance && i+j<len; j++){
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        if (dp[len-1] != Integer.MAX_VALUE)
            return dp[len-1];
        return -1;
    }


}
