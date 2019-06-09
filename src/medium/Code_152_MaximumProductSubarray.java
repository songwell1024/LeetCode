package medium;

import sun.nio.cs.ext.MacThai;

/**
 * @ClassName: Code_152_MaximumProductSubarray
 * @Description:
 * 给定一个整数数组 nums，找到具有最大乘积（包含至少一个数字）的连续子数组。
 * @Author: WilsonSong
 * @Date: 2019/6/9 11:20
 * @Version 1.0
 **/
public class Code_152_MaximumProductSubarray {
    //有小与0 的数，下面的方法不行
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = dpMax[0];

        for (int i = 1; i < nums.length; i ++){
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]), nums[i]);
            max = Math.max(dpMax[i], max);
        }
        return max;
    }
    //暴力解决
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i= 0; i< nums.length; i++){
            int res = 1;
            for (int j = i; j< nums.length; j++){
                res = nums[j] * res;
                max = Math.max(max,res);
            }


        }
        return max;
    }
}
