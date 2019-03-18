package getOffer;

import java.util.HashMap;

/**
 * @program:
 * @description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author: Song
 * @create: Created in 2019-03-18 15:59
 * @Modified by:
 **/
public class Code_28_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if (hashMap.containsKey(array[i])){
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
                if (hashMap.get(array[i]) > array.length /2){
                    return array[i];
                }
            }else {
                hashMap.put(array[i], 1);
            }
        }
       return 0;
    }

}
