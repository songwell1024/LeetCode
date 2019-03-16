package medium;

/**
 * @program:
 * @description: 机器人位于m x n网格的左上角（在下图中标记为“开始”）。
 *
 * 机器人只能在任何时间点向下或向右移动。机器人正试图到达网格的右下角（在下图中标记为“完成”）。
 *
 * 有多少可能的独特路径？
 * @author: Song
 * @create: Created in 2019-02-25 14:57
 * @Modified by:
 **/
public class Code_62_UniquePaths {

    //递归超时
    public static int uniquePaths1(int m, int n) {
        if (m < 0 || n < 0){
            return 0;
        }
        return uniquePathsProcess(1,1, m, n);
    }

    public static int uniquePathsProcess(int i, int j, int m, int n){
        if (i == m && j == n){
            return 1;
        }
        if (i > m || j > n){
            return 0;
        }

        return uniquePathsProcess(i + 1, j, m, n) + uniquePathsProcess(i, j +1, m, n);
    }

    //动态规划
    public static int uniquePaths(int m, int n){
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i ++){
            res[i][n-1] = 1;
        }
        for (int i = 0; i < n; i ++){
            res[m-1][i] = 1;
        }

        for (int i = m-2; i >= 0; i --){
            for (int j = n-2;  j >= 0; j -- ){
                res[i][j] = res[i +1][j] + res[i][j+1];
            }
        }
        return res[0][0];
    }
    public static void main(String[] args) {
        uniquePaths(3,2);
    }
}
