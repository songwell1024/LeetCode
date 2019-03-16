package getOffer;

/**
 * @program:
 * @description: 从左上角开始找
 * @author: Song
 * @create: Created in 2019-03-11 14:11
 * @Modified by:
 **/
public class Code_01_FindNumInArray {
    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0|| array[0].length == 0){
            return false;
        }
        int i = 0;
        int j = array[0].length -1;
        while (i < array.length && j >=0){
            if (array[i][j] == target){
                return true;
            }else if (array[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
     int[][] num = {{1,2,8,9},{4,7,10,13}};
    }
}
