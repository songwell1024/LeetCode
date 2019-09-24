package WrittenExamination.YunCong;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/24 18:28
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int p = sc.nextInt();
        int[] res = new int[p];
        int index = 1;
        while (c > index){
            for (int i = 0;i< p;i++ ){
                if (c - index <= 0){
                    res[i] = res[i] + c;
                }else {
                    res[i] = res[i] + index;
                }

                c = c - index;
                if (c <= 0){
                    break;
                }
                index++;
            }
        }
        for (int i = 0; i< p; i++){
            System.out.println(res[i]);
        }
    }
}
