package WrittenExamination.YunCong;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/24 18:47
 * @Version 1.0
 **/
public class Main3 {
    public static int getMinNum(int[] coins, int money) {
        int dp[]=new int[money+1];
        dp[0]=0;
        for(int i=1;i<=money;i++) {
            dp[i]=i;
        }
        for(int i=1;i<=money;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i>coins[j]&&(dp[i-coins[j]]+1)<dp[i]) {
                    dp[i]=dp[i-coins[j]]+1;
                }
            }
        }
        return dp[money];
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0;i <= amount;i ++){//初始化
            dp[i] = Integer.MAX_VALUE - 1;//避免下面溢出
        }
        for (int i = 0;i < coins.length;i ++){//更新dp
            if (coins[i] <= amount){
                dp[coins[i]] = 1;
            }
        }
        for (int i = 0;i < coins.length;i ++){
            for (int j = 0;j <= amount;j ++){
                if (j >= coins[i] && dp[j - coins[i]] >= 0){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] >= Integer.MAX_VALUE - 1) return -1;
        else{
            return dp[amount];
        }
    }
}
