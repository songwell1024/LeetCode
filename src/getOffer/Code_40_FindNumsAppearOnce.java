package getOffer;

/**
 * @program:
 * @description:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * @author: Song
 * @create: Created in 2019-03-22 15:12
 * @Modified by:
 **/
public class Code_40_FindNumsAppearOnce {

    /**
     * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
     * @param array
     * @param num1
     * @param num2
     * 作者：zt110e5
     * 链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811
     * 来源：牛客网
     *
     * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字，这个解法这个中，基本也是按剑指offer中思路来的。
     * 第二个for()的意思是：sum的二进制表示中，1的位数，表示的是两个唯一数字二进制表示中不同的位，
     * 我们就找出第一个1所在的位数(index)，在第三个for()循环中按照这个位将数组分成两个子数组，
     * 分组标准是数字在这个位上的值是否为1（此时数字相同的各位也相同，在同一个组中；不同数字，也就不在同一组里）。
     * 之后按照异或分别找出那两个唯一数即可。
     */
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
    /**
     * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
     * @param a
     * @return
     */
    public static int find1From2(int[] a){
        int len = a.length, res = 0;
        for(int i = 0; i < len; i++){
            res = res ^ a[i];
        }
        return res;
    }
    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * 我们换一个角度来看，如果数组中没有x，那么数组中所有的数字都出现了3次，在二进制上，每位上1的个数肯定也能被3整除。如{1, 5, 1, 5, 1, 5}从二进制上看有：
     *
     * 1：0001
     *
     * 5：0101
     *
     * 1：0001
     *
     * 5：0101
     *
     * 1：0001
     *
     * 5：0101
     *
     * 二进制第0位上有6个1，第2位上有3个1.第1位和第3位上都是0个1，
     * 每一位上的统计结果都可以被3整除。而再对该数组添加任何一个数，
     * 如果这个数在二进制的某位上为1都将导致该位上1的个数不能被3整除。
     * 因此通过统计二进制上每位1的个数就可以推断出x在该位置上是0还是1了，这样就能计算出x了。
     * @param a
     * @return
     */
    public static int find1From3(int[] a){
        int[] bits = new int[32];
        int len = a.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < 32; j++){
                bits[j] = bits[j] + ( (a[i]>>>j) & 1);
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bits[i] % 3 !=0){
                res = res | (1 << i);
            }
        }
        return res;
    }
}
