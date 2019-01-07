package Easy;

/**
 * 假设您有一个数组，其中第i 个元素是第i天给定股票的价格。
 设计算法以找到最大利润。您可以根据需要完成尽可能多的交易（即，多次买入并卖出一股股票）。
 只要上涨就买入，下降就卖出
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_122_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int res = 0;
        int buy = prices[0];
        int sell = prices[0];
        for (int i = 1; i< prices.length; i ++){
            if (sell <= prices[i]){
                sell = prices[i];
            }else {
                res += (sell - buy);
                buy = prices[i];
                sell = prices[i];
            }
        }
        if (sell > buy){
            res += (sell - buy);
        }
        return res;
    }

    public static void main(String[] args){
        int[] p = {1,3,5,3,7,2};
        System.out.println(maxProfit(p));


    }


}
