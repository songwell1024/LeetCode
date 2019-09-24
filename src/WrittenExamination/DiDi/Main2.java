package WrittenExamination.DiDi;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/27 19:49
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.valueOf(s.split(" ")[0]);
        int Total = Integer.valueOf(s.split(" ")[1]);
        int Cost = Integer.valueOf(s.split(" ")[2]);
        String A = sc.nextLine();
        String[] charsA = A.split(" ");

        StringBuilder strA = new StringBuilder();
        for (String s1: charsA){
            strA.append(s1);
        }
        String B = sc.nextLine();
        String[] charsB = B.split(" ");
        StringBuilder strB = new StringBuilder();
        for (String s1: charsB){
            strB.append(s1);
        }
        int res = findLCS(strA.toString(),strB.toString());
        if (res * Cost > Total){
            System.out.println(Total /Cost);
            return;
        }
            System.out.println(res);

    }
    //最长公共子序列
    public static int findLCS(String a ,String b) {
        int s1len = a.length();
        int s2len = b.length();

        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();

        int[][] lcs = new int[s1len][s2len];

        //把第一行写好
        int flag = 0;
        for (int i = 0; i < s2len ; i++) {
            if (s1[0] == s2[i]) {
                flag = 1;
            }
            lcs[0][i] = flag;
        }
        //吧第一列写好
        flag = 0;
        for (int i = 0; i < s1len; i++) {
            if (s2[0] == s1[i]) {
                flag = 1;
            }
            lcs[i][0] = flag;
        }

        for (int i = 1; i < s1len; i++) {
            for (int j = 1; j < s2len; j++) {
                if (s1[i] == s2[j]) {
                    //如果对比时，某两个字符相等，那么当前最大值 = 两个s都不看这个当前字符时候的最大值+1
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                else {
                    //他等于两个字符串分别上一次匹配的最大值
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }

        }
        return (lcs[s1len - 1][s2len - 1]);
    }
}
