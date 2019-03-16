package getOffer;

import java.util.ArrayList;

/**
 * @program:
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * @author: Song
 * @create: Created in 2019-03-14 14:37
 * @Modified by:
 **/
public class Code_19_printMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        process(matrix,list,0,0, matrix.length -1 , matrix[0].length-1);
        return list;
    }

    public static void process(int [][] matrix, ArrayList<Integer> list, int i, int j, int row, int line){
        if (i > row || j >line){
            return;
        }
        if (i == row && j ==line){
            list.add(matrix[i][j]);
            return;
        }
        if (i == row){
            while (j <= line){
                list.add(matrix[i][j]);
                j++;
            }
            return;
        }
        if (j == line){
            while (i <= row){
                list.add(matrix[i][j]);
                i++;
            }
            return;
        }

        int x = i;
        int y = j;
       while (y < line ){
           list.add(matrix[x][y]);
           y++;
       }
       while (x < row){
           list.add(matrix[x][line]);
           x++;
       }
       while (y > j){
           list.add(matrix[row][y]);
           y--;
       }
       while (x > i){
           list.add(matrix[x][y]);
           x--;
       }

        process(matrix, list, i + 1,j + 1, row -1, line -1);

    }

    public static void main(String[] args) {
        int[][]  nums = {{1,2},{3,4}};
        printMatrix(nums);
        System.out.println("1");

    }
}
