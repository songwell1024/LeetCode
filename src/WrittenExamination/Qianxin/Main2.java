package WrittenExamination.Qianxin;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/9 19:37
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        int n =(int) Math.pow(2,level) -1;
        int[] num = new int[n];
        for (int i = 0; i < n;i++){
            num[i] = sc.nextInt();
        }
        int l = sc.nextInt();
        int r = sc.nextInt();
        int lIndex = -1;
        int rIndex = -1;
        for (int i = 0; i< n; i++){
            if (num[i] == l){
                lIndex = i;
            }else if (num[i] == r){
                rIndex = i;
            }
        }
        while (lIndex >= 0 && rIndex >= 0){
            if (lIndex > rIndex){
                lIndex = (lIndex-1)/2;
            }else if (rIndex > lIndex){
                rIndex =(rIndex-1)/2;
            }else {
                System.out.println(num[lIndex]);
                return;
            }
        }
        System.out.println(-1);
    }
}
