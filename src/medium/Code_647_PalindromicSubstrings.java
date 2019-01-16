package medium;

/**
 * @program:
 * @description: 给定一个字符串，您的任务是计算此字符串中的回文子串数。
 * @author: Song
 * @create: Created in 2019-01-16 18:58
 * @Modified by:
 **/
public class Code_647_PalindromicSubstrings {

    public static int countSubstrings(String s) {
        if (s == null){
            return 0;
        }
        int res = 0;
        for (int m = 0; m <= s.length()-1; m ++){
            for (int n = m; n <= s.length()-1;n ++){
                res = res + process(s.toCharArray(), m,n);
            }
        }
        return res;
    }

    public static int process(char[] chars, int i, int j){
        if (i == j || chars.length == 1) {
            return 1;
        }
        int res = 0;
        int start = i;
        int end = j;
        while (chars[start] == chars[end]){
            start++;
            end --;
            if (start >= end){
                res = 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "aaa";
        countSubstrings(s);

    }
}
