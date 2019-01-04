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

    public static void main(String[] args){
        System.out.println(countPrimes(3));
    }
}
