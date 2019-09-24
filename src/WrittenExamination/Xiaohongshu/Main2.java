package WrittenExamination.Xiaohongshu;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/18 15:33
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] strs = in.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i=strs.length-1; i>=0; i--){
           res.append(strs[i]);
        }
        System.out.println(res.toString());

    }
}
