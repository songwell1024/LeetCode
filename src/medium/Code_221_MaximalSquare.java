package medium;

/**
 * @program: LeetCode
 * @description:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * @author: Song
 * @create: 2019-05-30 19:19
 **/
public class Code_221_MaximalSquare {
//    int cur ;
//    public int maximalSquare(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
//            return 0;
//        }
//        int res = 0;
//        for (int i = 0; i < matrix.length -1; i++){
//            for (int j = 0; j < matrix[0].length - 1; j++){
//                if (matrix[i][j] == '1'){
//                    cur = 1;
//                }else {
//                    cur = 0;
//                }
//                dfs(matrix, i, j);
//                res = Math.max(res, cur * cur);
//            }
//        }
//        return res;
//    }
//
//    public boolean dfs(char[][] matrix, int i, int j){
//        if (matrix[i][j] == '1'){
//            if (i < matrix.length -1 && j < matrix[0].length -1){
//                if (dfs(matrix,i + 1, j) && dfs(matrix, i, j +1) && dfs(matrix, i+1, j+1)){
//                    cur = cur + 1;
//                }
//            }
//            return true;
//        }else {
//            return false;
//        }
//    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int cur = 0;
                while (i + cur< matrix.length && j + cur < matrix[0].length){
                    int m = 0;
                    for (;m < cur; m ++){
                        if(matrix[i+m][j + cur] =='1'){
                            m++;
                        }else {
                            break;
                        }
                    }
                    if (m == cur){
                        m = 0;
                        for (;m < cur; m ++){
                            if(matrix[i + cur][j + m] =='1'){
                                m++;
                            }else {
                                break;
                            }
                        }
                    }else {
                        break;
                    }
                    if (matrix[i + cur][j + cur] == '1' && m == cur){
                        cur = cur + 1;
                    }else {
                        break;
                    }

                }
                res = Math.max(res, cur * cur);
            }
        }
        return res;
    }

    /**
     * dp[i][j] 代表在以i, j这一格为右下角的正方形边长。
     * 如果这一格的值也是1，那这个正方形的边长就是他的上面，左手边，和斜上的值的最小边长 +1。因为如果有一边短了缺了，都构成不了正方形。
     * @param a
     * @return
     */
    public int maximalSquare2(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }

}
