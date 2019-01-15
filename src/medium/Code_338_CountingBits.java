package medium;

/**
 * @program:
 * @description: 给定非负整数num。对于范围0≤i≤num中的每个数字i，计算其二进制表示中的1的数量并将它们作为数组返回。
 * @author: Song
 * @create: Created in 2019-01-15 15:04
 * @Modified by:
 **/
public class Code_338_CountingBits {

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++){
            res[i] = computeBitNum(i);

        }
        return res;
    }

    public static int computeBitNum(int num){
        int res = 0;
        for (int i = 31; i>=0; i--){
           res += (((num >>> i) & 1) == 0 ? 0 : 1);
        }
        return res;
    }

}
