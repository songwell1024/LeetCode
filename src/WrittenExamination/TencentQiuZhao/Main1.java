package WrittenExamination.TencentQiuZhao;


import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/1 20:03
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.nextLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int m = Integer.parseInt(s.split(" ")[1]);
        int[] boxs = new int[n];
        int[] keys = new int[m];
        int res1 = 0;
        int res2 = 0;
        int res3 = 0;
        int res4 = 0;
        for (int i = 0; i< n;i++){
            boxs[i] = sc.nextInt();
            if (boxs[i] %2 == 0){
                res1++;
            }else {
                res2 ++;
            }
        }
        for (int i = 0; i< m; i++){
            keys[i] = sc.nextInt();
            if (keys[i] %2 == 0){
                res3++;
            }else {
                res4++;
            }
        }
        System.out.println(Math.min(res1, res4)+ Math.min(res2, res3));

    }
}
