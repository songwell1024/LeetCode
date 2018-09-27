package Easy;

/**
 * 给定表示非负整数的非空数字数组，加上整数的1。
 存储数字使得最高有效数字位于列表的开头，并且数组中的每个元素包含单个数字。
 您可以假设整数不包含任何前导零，除了数字0本身。
 例1：
 输入： [1,2,3]
 输出： [1,2,4]
 说明：数组表示整数123。
 例2：
 输入： [4,3,2,1]
 输出： [4,3,2,2]
 说明：数组表示整数4321。
 别想太多，每一位肯定是小于10 的，只需要考虑进位就可以了
 * @author WilsonSong
 * @date 2018/9/27/027
 */
public class PlusOne {

//    public int[] plusOne(int[] digits) {
//        int last = digits[digits.length-1] ;
//        last+=1;
//        String lastStr = String.valueOf(last);
//        int[] cur = new int[lastStr.length()];
//
//        for (int i = 0; i <lastStr.length(); i++ ){
//            char c = lastStr.charAt(i);
//            cur[i] = (int) c;
//        }
//        int cL = cur.length-1;
//        int dL = digits.length-1;
//        if (cL > dL){
//            for (int i = 0; i <= dL; i++){
//                cur[cL - dL + i] =  cur[cL - dL + i] + digits[i];
//            }
//        }
//
//    }

//    public static int[] plusOne(int[] digits) {
//        int L = digits.length;
//        digits[L-1] = digits[L-1]+1;
//        int cur = 0;
//        for (int i = 0; i < L; i++){
//            cur += digits[i] * (Math.pow(10, L-1-i));
//        }
//
//        String lastStr = String.valueOf(cur);
//        int[] res= new int[lastStr.length()];
//
//        for (int i = 0; i <lastStr.length(); i++ ){
//            char c = lastStr.charAt(i);
//            String s =String.valueOf(c);
//
//            res[i] = Integer.parseInt(s);
//        }
//        return res;
//    }

    public static int[] plusOne(int[] digits) {

        int L = digits.length;
        digits[L-1] = digits[L-1]+1;

        for (int i = L-1; i >0; i--){
            if (digits[i] >= 10){
                digits[i-1] +=1;
                digits[i] = digits[i] % 10;
            }
        }
        int[] res = new int[digits.length+1];
        if (digits[0] == 10){
            for (int i = 0; i < digits.length; i++){
                res[1+i] = digits[i];
            }
            res[0] = 1;
            res[1] = res[1] %10;
            return res;
        }
        return digits;
    }

    public static void main(String[] args){
        int[] a = {9,9,9};
        plusOne(a);
    }


}
