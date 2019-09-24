package WrittenExamination.dongfangcaifu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/6 19:09
 * @Version 1.0
 **/
public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String str1 = s.split(" ")[0];
//        String str2 = s.split(" ")[1];
//        String str3 = s.split(" ")[2];
//        if ((str1.length() + str2.length()) != str3.length()){
//            System.out.println("FALSE");
//            return;
//        }else {
//            int s1 = 0;
//            int s2 = 0;
//            for (int i = 0; i< str3.length(); i++){
//                if (s1 < str1.length() && str3.charAt(i) == str1.charAt(s1)){
//                    s1++;
//                }else if (s2 < str2.length() && str3.charAt(i) == str2.charAt(s2)){
//                    s2++;
//                }else {
//                    System.out.println("FALSE");
//                    return;
//                }
//            }
//        }
//        System.out.println("TRUE");
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] str1;
        if (s.split(" ")[0].equals(" ") && s.split(" ")[1].equals(" ") && s.split(" ")[2].equals(" ")){
            System.out.println("TRUE");
            return;
        }else if (s.split(" ")[0].equals(" ") && s.split(" ")[1].equals(" ") &&(!s.split(" ")[2].equals(" "))){
            System.out.println("FALSE");
            return;
        }else if (s.split(" ")[0].equals(" ")){
            str1 = (s.split(" ")[1]).toCharArray();
            Arrays.sort(str1);
        }else if (s.split(" ")[1].equals(" ")){
            str1 = (s.split(" ")[0]).toCharArray();
            Arrays.sort(str1);
        }else {
            str1 = (s.split(" ")[0] +s.split(" ")[1]).toCharArray();
            Arrays.sort(str1);
        }


        char[] str2 = s.split(" ")[2].toCharArray();
        Arrays.sort(str2);
        if (str1.length != str2.length){
            System.out.println("FALSE");
            return;
        }else {
            for (int i = 0; i< str1.length; i++){
                if (str1[i] != str2[i]){
                    System.out.println("FALSE");
                    return;
                }
            }
        }
        System.out.println("TRUE");
    }
}
