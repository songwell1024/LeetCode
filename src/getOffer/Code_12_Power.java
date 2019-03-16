package getOffer;

/**
 * @program:
 * @description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author: Song
 * @create: Created in 2019-03-12 15:49
 * @Modified by:
 **/
public class Code_12_Power {
    public static double Power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        if (base ==1){
            return base;
        }
        if (base == 0 && exponent < 0){
            return Double.POSITIVE_INFINITY;
        }
        double help = base;
        int res = 2;
        int flag = 0;
        if (exponent > 0){
            flag =1;
        }else {
            flag = -1;
        }
        while (res < Math.abs(exponent)){
            base = base *base;
            res *= 2;
        }
        res= (res /2 + 1);
        while (res <= Math.abs(exponent)){
            base *= help;
            res++;
        }

        if (flag > 0){
            return base;
        }else {
            return 1/ base;
        }
    }

    public static void main(String[] args) {
        Power(2,3);
    }
}
