package WrittenExamination.Wangyi;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 16:37
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i< n; i++){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j< arr.length; j++){
                arr[j] = sc.nextInt();
            }
            System.out.println(process(arr));
        }
    }

    public static int  process(int[] num){
        int res = 1;
        int sum =num[0];
        int l = 1;
        for (int i=1; i< num.length; i++){
            if (num[i]> num[i-1] && num[i] > sum){
                sum += num[i];
                l++;
                res =Math.max(res, l);
            }else {
                sum = num[i];
                l =1;
            }
        }
        return res;
    }
}
