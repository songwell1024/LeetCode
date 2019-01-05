package Easy;

/**
 * 不使用+ -计算两个整数的和
 * @author WilsonSong
 * @date 2019/1/5/005
 */
public class Code_371_SumOfTwoIntegers {

    //不用+-，比较两个数的大小
    public static int getMax(int a, int b) {

        int flagA = fit((a >> 31) & 1);
        int flagB = fit((b >> 31) & 1);
        int c = a - b;
        int flagC = fit((c >> 31) & 1);

        int difAB = flagA ^ flagB;
        int simAB = fit(difAB);

        int resA = difAB * flagA + simAB *flagC;
        int resB = fit(resA);

        return resA * a + resB * b;
    }

    public static int fit(int a){
        return a ^ 1;
    }


    //不用+—求两个数的和
    //    两个数异或：相当于每一位相加，而不考虑进位；
    //    两个数相与，并左移一位：相当于求得进位；
    public static int getSum(int a, int b){
        while (b != 0){
            int tmp = a ^ b;
            b = (a&b) << 1;
            a = tmp;
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(getSum(2,2));

    }
}
