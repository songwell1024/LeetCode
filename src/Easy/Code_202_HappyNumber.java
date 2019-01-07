package Easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 幸福数字是由以下过程定义的数字：从任何正整数开始，将数字替换为其数字的平方和，\并重复该过程，
 * 直到数字等于1（它将保留），或者循环在一个不包括1的循环中无休止地。这个过程以1结尾的那些数字是幸福的数字
 *
 * 定义一个hashset，当循环到不能在添加进元素的时候就返回false，或者等到过程中有1，返回true
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_202_HappyNumber {

    public static boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.add(n)){
            List<Integer> list = new LinkedList<>();
            while (n != 0){
                list.add(n%10);
                n = n / 10;
            }
            int res = 0;
            for (int i = 0; i< list.size(); i++){
                res += list.get(i) * list.get(i);
            }
            if (res == 1){
                return true;
            }else {
                n = res;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isHappy(19));
    }


}
