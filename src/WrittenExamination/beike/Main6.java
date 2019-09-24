package WrittenExamination.beike;

import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

/**
 * @ClassName: Main6
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/23 19:42
 * @Version 1.0
 **/
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ss = sc.nextLine();
        int n = Integer.parseInt(ss.split(" ")[0]);
        int k = Integer.parseInt(ss.split(" ")[1]);
        String t = sc.nextLine();
        if (t == null || t.length() == 0 || t.equals(" ")){
            System.out.println(t);
            return;
        }
        StringBuilder sb = new StringBuilder();

        String str = getStr(t);
        sb.append(t);
        k--;
        while ( k > 0){
            sb.append(str);
            k--;
        }
        System.out.println(sb.toString());
    }

    public static String getStr(String s){
        int l = 0;
        int r = s.length()-1;
        String res = s;
        while (r > 0){
            if (s.substring(0,l +1).equals(s.substring(r,s.length()))){
                l++;
                r--;
                res =s.substring(l,s.length());
            }else {
                l ++;
                r--;
            }
        }
        return res;
    }
}
