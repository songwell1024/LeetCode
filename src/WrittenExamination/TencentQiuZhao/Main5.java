package WrittenExamination.TencentQiuZhao;

import java.util.Scanner;

/**
 * @ClassName: Main5
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/1 21:09
 * @Version 1.0
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        for (int i =0; i<t; i++){
            long res = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j<= b; j++){
                res += getNum(j,k);
            }
            System.out.println((res) % 1000000007);
        }
    }
    public static int getNum(int a, int k){
        int res = 0;
        int index = 1;
        while (a - index*k >=0){
            res += (a-index*k+1);
            index++;
        }
        return res+1;
    }
}
