package medium;

/**
 * @program:
 * @description:
 * 假设您有一个数组，其中第i 个元素是第i天给定股票的价格。
 *
 * 设计算法以找到最大利润。您可以通过以下限制完成任意数量的交易（即，多次买入并卖出一股股票）：
 *
 * 您不得同时进行多笔交易（即，您必须在再次购买之前卖出股票）。
 * 在您出售股票后，您无法在第二天购买股票。（即冷却1天）
 * 输入：[1,2,3,0,2]
 *  输出： 3
 *  说明：交易= [买，卖，冷却，买，卖]
 * @author: Song
 * @create: Created in 2019-03-05 14:56
 * @Modified by:
 **/
public class Code_309_BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 递归超时
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices ==  null || prices.length == 0){
            return 0;
        }
        return Math.max(process(prices, 0, true, false), process(prices, 0, false, false));
    }

    /**
     * buy
     * @param prices
     * @param buy
     * @return
     */
    public int process(int[] prices, int index, boolean buy, boolean sell){
        if (index >= prices.length){
            return 0;
        }

        if (buy){
            return Math.max(-prices[index] + process(prices, index + 1, false, true), -prices[index] + process(prices, index + 1, false, false));
        }else if (sell){
            return Math.max(prices[index] + process(prices, index + 1, false, false), process(prices, index + 1, false, true));
        }else{
            return Math.max(process(prices, index + 1, true, false),process(prices, index + 1, false, false));
        }

    }

    /**
     *
     *
     * 1. Define States
     *
     * To represent the decision at index i:
     *
     * buy[i]: Max profit till index i. The series of transaction is ending with a buy.
     * sell[i]: Max profit till index i. The series of transaction is ending with a sell.
     * To clarify:
     *
     * Till index i, the buy / sell action must happen and must be the last action. It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
     * In the end n - 1, return sell[n - 1]. Apparently we cannot finally end up with a buy. In that case, we would rather take a rest at n - 1.
     * For special case no transaction at all, classify it as sell[i], so that in the end, we can still return sell[n - 1]. Thanks @alex153 @kennethliaoke @anshu2.
     * 2. Define Recursion
     *
     * buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1, or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
     * sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1, or buy at/before i - 1, then sell at i.
     * So we get the following formula:
     *
     * buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
     * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
     * 3. Optimize to O(1) Space
     *
     * DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.
     *
     * Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
     * Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
     * Then arrays turn into Fibonacci like recursion:
     *
     * b0 = Math.max(b1, s2 - prices[i]);
     * s0 = Math.max(s1, b1 + prices[i]);
     * 4. Write Code in 5 Minutes
     *
     * First we define the initial states at i = 0:
     *
     * We can buy. The max profit at i = 0 ending with a buy is -prices[0].
     * We cannot sell. The max profit at i = 0 ending with a sell is 0.
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; s2 = s1; s1 = s0;
        }
        return s0;
    }

}
