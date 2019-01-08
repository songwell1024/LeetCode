package Easy;

import javax.swing.plaf.metal.MetalFileChooserUI;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * @author WilsonSong
 * @date 2019/1/8/008
 */
public class Code_172_FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int fiveNum = 0;
        for (int i = 1; i <= n; i++){
         if (i % 5 == 0){
                int cur = i;
                while (cur % 5 == 0){
                    fiveNum++;
                    cur = cur / 5;
                }

            }
        }
        return fiveNum;
    }

    //2147483647
    public static int trailingZeroes2(int n) {
        int fiveNum = 1;
        int res = 0;
        int i = 2;
        while (fiveNum <= n){
            if (i % 5 == 0){
                int cur = i;
                while (cur % 5 == 0 && cur != 0){
                    res += 1;
                    cur = cur / 5;
                }
                res++;
                fiveNum = 5 * i;
                i++;
            }else {
                res++;
                fiveNum = 5 * i;
                i++;
            }
        }
        return res;
    }

    public static int trailingZeroes3(int n) {
        return n==0? 0 : n/ 5 + trailingZeroes3(n / 5);
    }
    public static void main(String[] args){
        System.out.println(trailingZeroes2(155));

    }

}
