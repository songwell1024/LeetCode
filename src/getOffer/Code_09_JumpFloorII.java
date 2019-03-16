package getOffer;

/**
 * @program:
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: Song
 * @create: Created in 2019-03-12 15:07
 * @Modified by:
 **/
public class Code_09_JumpFloorII {
    public static int JumpFloorII(int target) {
       int[] dp = new int[target + 1];
       dp[0] = 0;
       dp[1] = 1;

       for (int i = 2; i <= target; i ++){
           for (int j = i -1; j > 0; j--){
               dp[i] += dp[j];
           }
           dp[i] = dp[i] + 1;
       }
       return dp[target];
    }

    public static void main(String[] args) {
        JumpFloorII(3);
    }
}
