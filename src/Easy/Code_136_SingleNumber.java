package Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * @author WilsonSong
 * @date 2019/1/4/004
 */
public class Code_136_SingleNumber {
    public static int singleNumber(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums){
            if (treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num) + 1 );
            }else {
                treeMap.put(num, 1);
            }
        }

        for (int num: nums){
            if (treeMap.get(num) == 1){
                return num;
            }
        }
        return 0;
    }


    // 0 ^ n = n;  n ^ n = 0
    public int singleNumber2(int[] nums) {
        int result=0;
        for(int num : nums) {
            result=result^num;
        }
        return result;
    }
    public static void main(String[] args){
        int[] num ={4,1,2,1,2,2,2,2};
        System.out.println(singleNumber(num));
    }


}
