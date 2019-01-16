package medium;

/**
 * @program:
 * @description: Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * @author: Song
 * @create: Created in 2019-01-16 19:53
 * @Modified by:
 *
 * 只要从数组的最后开始把数的乘积算出来，然后在前面计算的时候把前面的数的乘积也记住，然后一遍遍历就算完了
 **/
public class Code_238_ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int[] mul = new int[nums.length];
        mul[nums.length-1] = nums[nums.length -1];
        for (int i = nums.length -2; i >= 0; i--){
            mul[i] =nums[i] * mul[i + 1];
        }
        int[] res = new int[nums.length];
        int num = 1;
        for (int i = 0; i < nums.length -1; i++){
            res[i] = num * mul[i + 1];
            num *= nums[i];
        }

        res[nums.length-1] = num;
        return res;

    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);

    }

}
