package medium;

import java.util.Arrays;

/**
 * @ClassName: Code_322_CoinChange
 * @Description:
 * 您将获得不同面额的硬币和总金额。编写一个函数来计算构成该数量所需的最少数量的硬币。
 * 如果这笔钱不能由任何硬币组合弥补，则退货-1。
 * @Author: WilsonSong
 * @Date: 2019/6/9 9:17
 * @Version 1.0
 **/
public class Code_322_CoinChange {
    //递归
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed
        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }

    //动态规划
    //dp[i]表示能组成i的最少使用的硬币的数量
    public int coinChange2(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i<= amount; i++){
            int min = -1;
            for (int coin : coins){
                if (i >= coin && dp[i - coin]!= -1){
                    int temp = dp[i - coin] + 1;
                    min = min < 0 ? temp:(temp < min ? temp : min);
                }
            }
            dp[i] =  min;
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
