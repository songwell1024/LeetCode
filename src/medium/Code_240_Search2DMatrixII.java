package medium;

/**
 * @program:
 * @description:
 * 编写一个有效的算法，搜索m × n矩阵中的值。该矩阵具有以下属性：
 *
 * 每行中的整数按从左到右的升序排序。
 * 每列中的整数按从上到下的顺序排序。
 * @author: Song
 * @create: Created in 2019-04-09 14:28
 * @Modified by:
 **/
public class Code_240_Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length -1][matrix[0].length -1]){
            return false;
        }

        int rows = 0;
        int cows = matrix[0].length -1;
        while (rows < matrix.length && cows >= 0){
            if (matrix[rows][cows] == target){
                return true;
            }else {
                if (matrix[rows][cows] > target){
                    cows --;
                }else if (matrix[rows][cows] < target){
                    rows++;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

}
