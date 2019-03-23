package getOffer;

/**
 * @program:
 * @description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author: Song
 * @create: Created in 2019-03-23 18:15
 * @Modified by:
 **/
public class Code_48_Add {
    public static int Add(int num1,int num2) {
        int res = 0;
        int flag = 0;
        for (int i = 0; i < 32; i++){
            if (((num1 >> i) & 1 )==1 && ((num2>>i) & 1) ==1 && flag ==1){
                res = (res | (1<<i));
            }else if (((num1 >> i) & 1 )==1 && ((num2>>i) & 1) ==1 && flag == 0){
                flag = 1;
            }else if (((num1 >> i) & 1 )==0 && ((num2>>i) & 1) == 0){
                res = (res | (flag<<i));
                flag = 0;
            }else {
                if (flag == 0){
                    res  = (res |(1 << i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Add(3,3);
    }

}
