package getOffer;

/**
 * @program:
 * @description:
 * 连续子数组的最大和
 * @author: Song
 * @create: Created in 2019-03-19 19:08
 * @Modified by:
 **/
public class Code_30_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        if (array == null || array.length == 0){
            return 0;
        }
        dp[0] = array[0];
        int res = dp[0];
        for (int i = 1; i < array.length; i++){
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

}
