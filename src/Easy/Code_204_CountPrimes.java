package Easy;

/**
 * 找小于非负数n的素数数量
 * @author WilsonSong
 * @date 2019/1/4/004
 */
public class Code_204_CountPrimes {

    //该方法超时
    public static int countPrimes(int n) {
        if (n<= 2){
            return 0;
        }
        int res = 0;
        for(int i = 2; i < n; i ++){
            int count = 2;
            for(int j = i-1; j >= 2; j --){
                if (i % j == 0){
                    break;
                }else {
                    count ++;
                }
            }
            if (count == i){
                res ++;
            }
        }
        return  res;
    }

    //这和上面的没有区别，只是换了一种写法而已，还是o(n2)
    public static int countPrimes2(int n) {
        if (n <= 2){
            return 0;
        }
        int[] dp = new int[n];
        dp[1] = 0;

        for (int i = 2; i < n; i ++){
            dp[i] = dp[i-1] + (isPrimes(i)? 1 : 0);
        }
        return dp[n-1];
    }

    public static boolean isPrimes(int n){

        for(int j = n -1; j >=2; j --){
            if (n % j == 0){
                return false;
            }
        }
        return true;
    }

    //从j = i开始算的话，可能会越界，所以从j=2开始算，尽管这样会有重复计算，但是会避免越界的问题出现
    public static int countPrimes3(int n){
        if (n <=2){
            return 0;
        }

        boolean[] isPrimes = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++){
            if (isPrimes[i] ==  false){
                res++;
                for(int j = 2; i*j < n; j++){
                    isPrimes[i*j] = true;
                }
            }
        }
        return res;
    }


    public static void main(String[] args){
        System.out.println(countPrimes3(999999));
    }
}
