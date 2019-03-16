package getOffer;

/**
 * @program:
 * @description: 斐波那契数列
 * @author: Song
 * @create: Created in 2019-03-11 16:48
 * @Modified by:
 **/
public class Code_07_Fibonacci {
    //递归
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        return Fibonacci(n -2) + Fibonacci(n -1);
    }

    //动态规划
    public static int Fibonacci2(int n) {
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i<= n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci2(3);
    }

}
