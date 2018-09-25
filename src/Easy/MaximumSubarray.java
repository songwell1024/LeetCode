package Easy;

/**
 * 找数组中具有最大和的非连续的子数组
 *  * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 * @author WilsonSong
 * @date 2018/9/25/025
 */
public class MaximumSubarray {

    public  static int maxSubArray(int[] nums) {
        return maxSubArrayProcess(nums,0);
    }

    public static int  maxSubArrayProcess(int[] nums, int k){
        if (k == nums.length-1){
            return nums[k];
        }
        return Math.max(maxSubArrayProcess(nums, k+1),nums[k] + maxSubArrayProcess(nums, k+1));
    }

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println( maxSubArray(nums));
    }
}
