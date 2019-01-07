package Easy;

/**
 * 是否是3的幂
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_326_PowerOfThree {
    public boolean isPowerOfThree(int n) {

        int res = 1;
        while (res < n){
            res = res * 3;
        }
        if (res == n){
            return true;
        }else {
            return false;
        }
    }

    //3^19是最大的3的幂次数
    public boolean isPowerOfThree2(int n) {
            return n > 0 && (1162261467 % n == 0);

    }


}
