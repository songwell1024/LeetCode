package medium;

/**
 * @program:
 * @description: 矩阵从开始走到最后的最小路径和
 * @author: Song
 * @create: Created in 2019-02-25 15:59
 * @Modified by:
 **/
public class Code_64_MinimumPathSum {
//    public int minPathSum(int[][] grid) {
//        if (grid == null){
//            return -1;
//        }
//
//        return minPathSumProcess(0,0,grid);
//    }
//
//    public int minPathSumProcess(int i, int j, int[][] grid){
//        if (i == grid.length-1 && j == grid[0].length -1){
//            return grid[i][j];
//        }else if (i < grid.length - 1 && j < grid[0].length -1){
//            return Math.min(minPathSumProcess(i + 1, j, grid) + grid[i][j], minPathSumProcess(i , j + 1, grid) + grid[i][j]);
//        }
//        return 0;
//    }

    public static int minPathSum2(int[][] grid) {
        if (grid == null){
            return -1;
        }
        int[][] res = new int[grid.length][grid[0].length];
        res[grid.length -1][grid[0].length -1] = grid[grid.length -1][grid[0].length -1];
        for (int i =grid.length -2 ; i >=0; i --){
            res[i][grid[0].length-1] = grid[i][grid[0].length-1] +res[i + 1][grid[0].length-1] ;
        }
        for (int i = grid[0].length -2; i >=0; i --){
            res[grid.length-1][i] = grid[grid.length-1][i] + res[grid.length-1][i + 1];
        }

        for (int i = res.length -2; i >= 0; i --){
            for (int j = res[0].length -2; j >=0; j --){
                res[i][j] = Math.min(res[i + 1][j], res[i][j+1]) + grid[i][j];
            }
        }
        return res[0][0];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        minPathSum2(grid);
    }


}
