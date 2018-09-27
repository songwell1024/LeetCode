package Easy;


/**
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"

 二进制求解的思路：计算机计算二进制加法是分三部，第一步为将两个加数转换为二进制数，计算两个加数不需要进位的和（利用异或运算 ^ ），
 得出的结果。第二部将两个加数进行与运算（&）。第三部利用与运算得到结果进行左移运算（<<）（同时为计算两个加数需要进位的和）,
 得出结果。将或异运算的结果和左移运算的结果作为两个新的加数，重复此操作。直到当与运算的结果为0，则异或运算的结果则为两个加数的和所对应的二进制数。

 我下面的解法是直接暴力解决，添加标记作为进位的标记

 * @author WilsonSong
 * @date 2018/9/27/027
 */
public class AddBinary {

    public  static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int aL = a.length()-1;
        int bL = b.length()-1;
        int r = 0;     //表示进位
        if (aL > bL){
            for (int i = aL; i >=0; i--){
                char Ca = a.charAt(i);
                if (i-aL + bL >=0){
                   char Cb = b.charAt(i-aL+bL);
                   String Sa = String.valueOf(Ca);
                   int Ia = Integer.parseInt(Sa);
                   String Sb = String.valueOf(Cb);
                   int Ib = Integer.parseInt(Sb);

                   if (Ia ==1 &&Ib ==1){
                       if (r ==1){
                           stringBuilder.append(1);
                           r = 1;
                       }else {
                           stringBuilder.append(0);
                           r = 1;
                       }
                   }else {
                       if (Ia+Ib+r >1){
                           stringBuilder.append(0);
                           r = 1;
                       }else {
                           stringBuilder.append(Ia +Ib +r);
                           r = 0;
                       }
                   }
                }else {
                    String s = String.valueOf(Ca);
                    int I = Integer.parseInt(s);
                    if (I ==1 &&  r ==1){
                        stringBuilder.append(0);
                        r = 1;
                    }else {
                        stringBuilder.append(I+r);
                        r = 0;
                    }
                }
            }
        }else {
            for (int i = bL; i >=0; i--){
                char Cb = b.charAt(i);
                if (i-bL + aL >=0){
                    char Ca = a.charAt(i-bL+aL);
                    String Sb = String.valueOf(Cb);
                    int Ib = Integer.parseInt(Sb);
                    String Sa = String.valueOf(Ca);
                    int Ia = Integer.parseInt(Sa);

                    if (Ia ==1 &&Ib ==1){
                        if (r ==1){
                            stringBuilder.append(1);
                            r = 1;
                        }else {
                            stringBuilder.append(0);
                            r = 1;
                        }
                    }else {
                        if (Ia+Ib+r >1){
                            stringBuilder.append(0);
                            r = 1;
                        }else {
                            stringBuilder.append(Ia +Ib +r);
                            r = 0;
                        }
                    }
                }else {
                    String s = String.valueOf(Cb);
                    int I = Integer.parseInt(s);
                    if (I ==1 &&  r ==1){
                        stringBuilder.append(0);
                        r = 1;
                    }else {
                        stringBuilder.append(I+r);
                        r = 0;
                    }
                }
            }
        }
        if (r==1){
            stringBuilder.append(r);
        }
        return stringBuilder.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args){

        String a = "101";
        String b = "111";

        System.out.println(addBinary2(a,b));

    }

}
