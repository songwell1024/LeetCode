package WrittenExamination.Wangyi;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 16:16
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i< n;i++){
            int num = sc.nextInt();
            System.out.println(process(num));
        }
    }

    public static String process(int num){
        StringBuilder sb =new StringBuilder();
        while (num != 0){
            if (num >= 1 && num <= 9){
                sb.append(num);
                break;
            }else {
                sb.append(9);
                num = 9;
            }
        }
        return sb.reverse().toString();
    }
}
