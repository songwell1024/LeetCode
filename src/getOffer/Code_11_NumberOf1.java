package getOffer;

/**
 * @program:
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author: Song
 * @create: Created in 2019-03-12 15:46
 * @Modified by:
 **/
public class Code_11_NumberOf1 {
    public int NumberOf1(int n) {

        int res = 0;
        for (int i = 0; i < 32; i++){
            res +=((n >> i) & 1);
        }
        return res;
    }


}
