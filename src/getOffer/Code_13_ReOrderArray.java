package getOffer;

import jdk.internal.dynalink.linker.LinkerServices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: Song
 * @create: Created in 2019-03-13 15:05
 * @Modified by:
 **/
public class Code_13_ReOrderArray {
    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        int[] res = new int[array.length];
        int index = 0;
        for (int num : array){
            if (num %2 != 0){
                res[index] = num;
                index ++;
            }
        }

        for (int num : array){
            if (num %2 == 0){
                res[index] = num;
                index ++;
            }
        }
        for (int i = 0; i < array.length; i++){
            array[i] = res[i];
        }
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
    }
}
