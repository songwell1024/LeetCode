package Easy;

/**
 * 编写一个取无符号整数的函数，并返回它所具有的“1”位数（也称为汉明权重）。
 * java中的整数有32位
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_191_NumberOf1Bits {

    public int hammingWeight(int n) {
        int res = 0;
        //依次往右移动，然后最低位比较看有多少个1
       for(int i = 0; i < 32; i++){
           res += (n>>>i)&1;
       }
       return res;

    }
}
