package WrittenExamination.JingDong;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/24 18:48
 * @Version 1.0
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] num = new int[n];
        String str = sc.nextLine();
        for (int i = 0; i< n; i++){
            num[i] = Integer.parseInt(str.split(" ")[i]);
        }
        int a = 0;
        int i = 0;
        while (i!=num.length-1)
        {
            if (num[i]<num[i+1])
            {
                a++;
                i++;
            }
            else
            {
                i++;
            }
        }
        if (a%2==0)
        {
            System.out.println(a);
        }
        else
        {
            System.out.println(a+1);
        }
    }
}