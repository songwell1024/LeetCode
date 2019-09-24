package WrittenExamination.KuaiShou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 21:06
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> list =  letterCombinations(s);
        System.out.print("[");
        for (int i = 0; i< list.size();i++){
            if (i < list.size()-1){
                System.out.print(list.get(i));
                System.out.print(", ");
            }else {
                System.out.print(list.get(i));
            }
        }
        System.out.println("]");
    }
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        char[] chars = digits.toCharArray();
        String[] strs = {"abc", "def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
        if (chars.length <= 0){
            return list;
        }
        if ((chars[0] - '2' >= 0) && (chars[0]- '9' <= 0)){
            for (int i = 0;  i < strs[chars[0] - '2'].length(); i++){
                list.add(""+strs[chars[0] - '2'].charAt(i));
            }
        }
        for (int i = 1; i < chars.length; i++){
            if ((chars[i] - '2' >= 0) && (chars[i]- '9' <= 0)){
                int k = list.size()-1;
                while (k >= 0){
                    String s = list.get(0);
                    list.remove(0);
                    for (int j = 0;  j < strs[chars[i] - '2'].length(); j++){
                        String help = s;
                        help += strs[chars[i] - '2'].charAt(j);
                        list.add(help);
                    }
                    k--;
                }

            }else {
                break;
            }
        }
        return list;
    }
}
