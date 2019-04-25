package WrittenExamination.MeiTuan;

import java.util.Scanner;

/**
 * @ClassName: MoveToBlackAndWitheMatrix
 * @Description:
 *垃圾没写出来啊
 * @Author: WilsonSong
 * @Date: 2019/4/23 20:20
 * @Version 1.0
 **/
public class MoveToBlackAndWitheMatrix {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] array = new int[row][col];
        for (int i=0; i<row; i++)
        {
            for (int j=0; j<col; j++)
            {
                array[i][j] = scanner.nextInt();
            }
        }
        int res  =0;
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
            }
        }
    }
}
