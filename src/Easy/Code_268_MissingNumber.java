package Easy;

import java.util.TreeSet;

/**
 * 给一个数组找缺失的数字
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_268_MissingNumber {
    public int missingNumber(int[] nums) {
        TreeSet<Integer> treeSet =  new TreeSet<>();
        for (int num: nums){
            treeSet.add(num);
        }

        for (int i = 0; i <= nums.length; i++){
            if (!treeSet.contains(i)){
                return i;
            }
        }
        return 0;
    }

    //基本思想是使用XOR操作。我们都知道a ^ b ^ b = a，这意味着具有相同数字的两个xor运算将消除数字并显示原始数字。
    //在此解决方案中，我将XOR操作应用于数组的索引和值。在没有缺失数字的完整数组中，
    // 索引和值应该完全对应（nums [index] = index），因此在缺少数组时，最后留下的是缺少的数字。
    public int missingNumber2(int[] nums){
        int xor = 0;
        int i = 0;
        for( i = 0; i < nums.length; i++){
            xor = xor ^ i ^ nums[i];
        }
        return xor^ i;
    }
}
