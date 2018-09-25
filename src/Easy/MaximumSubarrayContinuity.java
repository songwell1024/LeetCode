package Easy;

/**
 * * 找数组中具有最大和的连续子数组
 * 时间复杂度O(n)
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *  * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 * @author WilsonSong
 * @date 2018/9/25/025
 */
public class MaximumSubarrayContinuity {
//    时间复杂度O(N^2)
//    public  static int maxSubArray(int[] nums) {
//        int sum = nums[0];
//        int cur = 0;
//        for (int i = 0; i < nums.length; i++){
//            int n = nums.length-1;
//            while (n >=i){
//                cur = Sum(nums,i,n);
//                if (cur > sum){
//                    sum = cur;
//                }
//                n--;
//            }
//        }
//        return sum;
//    }
//
//
//    public static int Sum(int[] nums, int k, int n){
//        if (k == n){
//            return nums[k];
//        }
//        int sum = 0;
//        for (int i = k; i<= n; i++){
//            sum += nums[i];
//        }
//        return sum;
//    }

    //所以我将子问题的格式改为：maxSubArray(int A[], int i)，这意味着A [0：i]的maxSubArray必须有A [i]作为结束元素。请注意，
    // 现在子问题的格式不像前一个格式那样灵活且功能不强，因为A [i]应该包含在该序列中，我们必须跟踪子问题的每个解决方案以更新全局最优值。
    // 但是，现在子问题和原始问题之间的联系变得更加清晰：
    //maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];
    //其实也就是一个动态规划的问题
    //状态方程：max(dp[i]) = getMax(max(dp[i-1]) + a[i], a[i])。我们从头开始遍历数组，遍历到a[i]时，
    // 最大和可能是max(dp[i-1])+a[i]，也可能是a[i]。时间复杂度O(n)，空间复杂度O(n)。代码如下：
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
//        dp[0] = nums[0];
//        int max = dp[0];
//
//        for(int i = 1; i < n; i++){
//            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;
//    }

    public static int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i< nums.length; i++){
            dp[i] = dp[i-1] > 0 ? dp[i-1] : 0 + nums[i];
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {3,1};
        System.out.println( maxSubArray(nums));
    }
}
