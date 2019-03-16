package medium;

/**
 * @program:
 * @description:
 * 将矩阵旋转90度（顺时针）。
 * @author: Song
 * @create: Created in 2019-02-21 21:04
 * @Modified by:
 **/
public class Code_48_RotateImage {
    public static void rotate(int[][] matrix) {
        int right = matrix.length -1;
        int left = 0;

        while (left < right){
            process(left, right,matrix);
            left += 1;
            right = right - 1;
        }
    }

    public static void process(int start, int end, int[][] martix){
        for (int i = start; i < end; i++ ){
            int help = martix[i][end];  //1
            martix[i][end] = martix[start][i]; //1
            martix[start][i] = help; //4

            help = martix[end][end - i + start]; //16
            martix[end][end-i + start] = martix[start][i]; //4
            martix[start][i] = help; //16

            help = martix[end - i + start][start]; //13
            martix[end - i + start][start] = martix[start][i];
            martix[start][i] = help;
        }
    }

    public void rotate2(int[][] matrix) {
        int n=matrix.length;
        for (int i=0; i<n/2; i++)  //i的右边界是n/2，因为是对称的
            for (int j=i; j<n-i-1; j++) {   //j的右边界是n-i-1
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
    }

    public static void main(String[] args){
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(nums);
    }
}
