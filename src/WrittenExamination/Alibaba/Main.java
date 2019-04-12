package WrittenExamination.Alibaba;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/12 19:45
 * @Version 1.0
 **/
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
        int resNum = getNum(m);
        int resYear = 0;
        int sumPig = 0;
        while (resYear < Integer.MAX_VALUE){
            sumPig += getYear(resYear);
            if (sumPig >= m){
                break;
            }
            resYear++;
        }
        resYear += 2018;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= m; i++){
            int a = getNum(i);
            if (!list.contains(reverseNum(a))){
                list.add(reverseNum(a));
            }
            list2.add(a);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int kNum = list.get(k- 1);
        int findNum = reverseNum(kNum);
        int findK = 0;
        while (findK < list2.size()){
            if (list2.get(findK) == findNum){
                break;
            }
            findK++;
        }
        findK ++;
        return resNum +"," +resYear +"," + findK;

    }

    static int getNum(int m){
        if (m == 0){
            return 0;
        }

        if (m <= 3){
            return m + 1;
        }
        int[] dp = new int[m];
        dp[0] = 2;
        dp[1] = 3;
        dp[2] = 4;
        for (int i = 3; i < m; i ++){
            dp[i] = dp[i -2] + dp[i -3];
        }
        return dp[m-1];
    }

    static int getYear(int n){
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return getYear(n - 1) + getYear(n - 3);
    }

    static int reverseNum(int num){
        String s = String.valueOf(num);
        StringBuilder str = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--){
            str.append(s.charAt(i));
        }
        return Integer.parseInt(str.toString());
    }


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String[] line = in.nextLine().split(",");
//        int m = Integer.valueOf(line[0]);
//        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(20, 3));

    }
}
