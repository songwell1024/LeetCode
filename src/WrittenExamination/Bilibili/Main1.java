package WrittenExamination.Bilibili;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/20 19:26
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reverseWord(sc.nextLine());
//        String str[] = sc.nextLine().split(" ");
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = str.length; i>=0;i--){
//            stringBuilder.append(str[i]);
//        }
//        System.out.println(stringBuilder.toString());
    }
    public static void reverseWord(String word){
        char[] chars = word.toCharArray();
        reverse(chars,0, chars.length-1);
        int index =-1;
        for (int i = 0; i< chars.length; i++){
            if (chars[i] == ' '){
                int nextIndex = i;
                reverse(chars,index+1,nextIndex -1);
                index = nextIndex;
            }
        }
        reverse(chars,index + 1,chars.length-1);
        System.out.println(new String(chars));
    }

    public static void reverse(char[] chars,int l, int h){
        while (l< h){
            char tmp = chars[l];
            chars[l] = chars[h];
            chars[h] = tmp;
            l++;
            h--;
        }
    }
}
