package Easy;


/**
 * 假设您有一个数组，其中第i 个元素是第i天给定股票的价格。
 如果您只被允许完成最多一笔交易（即买入并卖出一股股票），请设计算法以找出最大利润。
 请注意，在购买之前不能出售股票。
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_121_BestTimeBuyAndSellStock1 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int res = 0;
        int buy = prices[0];
        int sell = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (buy < prices[i]){
                sell = prices[i];
                res = Math.max(res,sell - buy);
            }else {
                buy = prices[i];
            }
        }
        return res;
    }

}
