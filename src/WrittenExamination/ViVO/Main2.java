package WrittenExamination.ViVO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/22 16:11
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
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

    private static String solution(int[] input) {

        // TODO Write your code here
        StringBuilder sb = new StringBuilder();
        int N = input[0];
        int M = input[1];
        boolean[] flag = new boolean[N];
        for (int i = 0; i < N;i++){
            flag[i] = true;
        }
        int index = 0;
        int count = 0;
        int num = N;
        while (num > 1){
            if (flag[index]){
                count++;
                if (count % M == 0){
                    flag[index] = false;
                    num--;
                    sb.append(index+1);
                    sb.append(" ");
                }
            }
            index ++;
            if (index == N){
                index = 0;
            }
        }
        for (int i = 0; i< N; i++){
            if (flag[i]){
                sb.append(i+1);
                break;
            }
        }
        return sb.toString();
    }

}
