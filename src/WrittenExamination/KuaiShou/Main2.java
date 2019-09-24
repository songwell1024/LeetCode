package WrittenExamination.KuaiShou;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 22:12
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        if (isIPv4(string)){
            System.out.println("IPv4");
        } else if(isIPv6(string)){
            System.out.println("IPv6");
        } else {
            System.out.println("Neither");
        }
    }

    private static boolean isIPv4(String str){
        String[] strs = str.split("\\.");
        if (strs.length != 4)
            return false;
        for (int i=0; i<4; i++){
            String s = strs[i];
            if (s.startsWith("0") && !s.equals("0"))
                return false;
            if (s.length()==0 || s.length()>3)
                return false;
            int val = 0;
            for (int j=0; j<s.length(); j++){
                char c = s.charAt(s.length()-1-j);
                if (c>='0' && c<='9')
                    val += (c-'0')*Math.pow(10, j);
                else
                    return false;
            }
            if (val<0 || val>255)
                return false;
        }
        return true;
    }

    private static boolean isIPv6(String str){
        str = str.toLowerCase();
        String[] strs = str.split(":");
        if (strs.length != 8)
            return false;
        for (int i=0; i<8; i++){
            String s = strs[i];
            if (s.length() ==0 || s.length() > 4)
                return false;
            for (int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if ((c>='0'&&c<='9') || (c>='a'&&c<='f'))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}
