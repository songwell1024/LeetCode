package medium;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-02-28 20:36
 * @Modified by:
 **/

public class  Code_494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null){
            return 0;
        }
        return process(nums, 0,S);
    }

    public int process(int[] nums, int start, int S){
        if (S == 0 && start == nums.length){
            return 1;
        }
        if (start == nums.length && S != 0){
            return 0;
        }
        return process(nums, start + 1, S - nums[start]) + process(nums, start + 1, S + nums[start]);
    }

    //DP求解
    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];  //以为最大是-sum, 最小是sum,还有个0
        dp[0+sum] = 1;   // 选择0号来达到和0只有一种方法
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}
