package getOffer;

/**
 * @program:
 * @description:
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * @author: Song
 * @create: Created in 2019-03-23 18:38
 * @Modified by:
 **/
public class Code_49_StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0 || str.equals(" ")){
            return 0;
        }

        int res = 0;
        char[] chars = str.toCharArray();
        int help = 1;
        for (int i = chars.length -1; i >=0; i--){
            char c = chars[i];
            if (c >= '0' && c <= '9'){
                res += ((c - '0') * help);
                help = help *10;
            }else if (c == '-'){
                res =(0 - res);
            }else if (c == '+'){

            }else {
                return 0;
            }
        }
        return res;
    }
}
