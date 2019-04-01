package getOffer;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-04-01 15:49
 * @Modified by:
 **/
public class Code_66_movingCount {
    static boolean[] flag ;
    public static int movingCount(int threshold, int rows, int cols)
    {
        if (threshold >= rows * cols){
            return rows * cols;
        }
        flag = new boolean[rows * cols];
        return process(threshold, rows, cols, 0,0);
    }

    public static int process(int threshold, int rows, int cols, int r, int c){
        if (r >= rows || r < 0 || c >= cols || c < 0){
            return 0;
        }
        if (!flag[r * cols + c]){
            flag[r * cols + c] = true;
            if (lowerThan(threshold, r,c)){
                return 1 + process(threshold, rows, cols, r,c + 1) + process(threshold, rows, cols, r + 1, c )
                        + process(threshold, rows, cols, r,c -1) + process(threshold, rows, cols, r -1, c );
            }else {
                return 0;
            }
        }
        return 0;
    }

    public static boolean lowerThan(int threshold, int r, int c){
        int res = 0;
        while (r % 10 != 0){
            res += r %10;
            r /= 10;
        }
        while (c % 10 != 0){
            res += c %10;
            c /= 10;
        }
        if (res <= threshold){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 3,7));
    }


}
