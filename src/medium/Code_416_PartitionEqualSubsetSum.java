package medium;

/**
 * @ClassName: Code_416_PartitionEqualSubsetSum
 * @Description:
 * 给定仅包含正整数的非空数组，查找是否可以将数组划分为两个子集，使得两个子集中的元素总和相等。
 * 实际上，这是一个0/1背包问题，对于每个数字，我们可以选择与否。让我们假设dp [i] [j]表示是否
 * 可以从前i个数中得到特定的和j。如果我们可以从0-i中选择这样一系列数字，其总和为j，
 * 则dp [i] [j]为真，否则为假。
 *
 * 基本情况：dp [0] [0]为真; （零数由0和0组成）
 *
 * 转换函数：对于每个数字，如果我们不选择它，dp [i] [j] = dp [i-1] [j]，这意味着如
 * 果第一个i-1元素已经使它成为j，dp [我] [j]也会把它变成j（我们可以忽略nums [i]）。
 * 如果我们选择nums [i]。dp [i] [j] = dp [i-1] [j-nums [i]]，表示j由当前值nums [i]组成，
 * 剩余部分由其他先前数字组成。
 * 因此，转移函数是dp [i] [j] = dp [i-1] [j] || dp [i-1] [j-nums [i]]
 *
 * @Author: WilsonSong
 * @Date: 2019/4/12 14:22
 * @Version 1.0
 **/
public class Code_416_PartitionEqualSubsetSum {

    //从二维数组的动态规划来看，其实dp[i][j]的值只取决于某一行值得变换
    //dp [i] [j] = dp [i-1] [j] || dp [i-1] [j-nums [i]]
    //因为其实可以不用考虑i这个变量直接转换为1维的数组
    //这个最后的一行的循环必须从sum开始，只能倒着往前更新
//    如果合并array1，并array2在单个阵列array，如果您更新array反了，所有的依赖不会被感动了！
//
//            (n represents new value, i.e. updated)
//            . . ? . . ? n n n n n n n
//              #
//    但是，如果您更新前进，dp[j - nums[i - 1]]已经更新，则无法使用它：
//
//            (n represents new value, i.e. updated)
//    n n n n n ? . . . . . .  where another ? goes? Oops, it is overriden, we lost it :(
//            #
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum %2) != 0){
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums){
            for (int i = sum; i > 0; i--){
                if (i >= num){
                    dp[i] = dp[i]|| dp[i - num];
                }
            }
        }
        return dp[sum];
    }


    //二维数组的动态规划
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum+ 1];
        dp[0][0] = true;
        for (int i = 1; i < nums.length + 1; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++){
            dp[0][i] = false;
        }

        for (int i = 1; i < nums.length + 1; i++){
            for (int j = 1; j < sum + 1; j ++){
                dp[i][j] = dp[i-1][j];
                if (j > nums[i]){
                    dp[i][j] = dp[i][j] || dp[i-1][j -  nums[i]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    //递归超时了
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        return getEqualSubsetSumProcess(0,0,0,nums);
    }

    public boolean getEqualSubsetSumProcess(int x, int y, int index, int[] nums){
        if (index == nums.length){
            return x == y;
        }
        return getEqualSubsetSumProcess(x + nums[index], y, index + 1, nums) ||
                getEqualSubsetSumProcess(x, y + nums[index], index + 1, nums);
    }
}
