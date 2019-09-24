package WrittenExamination.beike;

import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/10 20:42
 * @Version 1.0
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int res = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++){
            if (w[i] > res){
                index = i;
            }
        }
        int resVal = 0;
        for (int i = 1; i < index; i++){
            if (w[i-1] >=w[i]){
                resVal += w[i-1] - w[i]+ 1;
                w[i] = w[i-1]+1;
            }
        }
        for (int i = n-1; n > index; n--){
            if (w[i] >= w[i-1]){
                resVal += w[i-1] - w[i] + 1;
                w[i-1] = w[i]+1;
            }
        }
        System.out.println(resVal);
    }
}
