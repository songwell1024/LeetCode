package getOffer;

/**
 * @program:
 * @description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: Song
 * @create: Created in 2019-03-11 16:13
 * @Modified by:
 **/
public class Code_06_MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        for (int i = 0; i < array.length -1; i++){
            if (array[i] > array[i + 1]){
                return array[i + 1];
            }
        }
        return array[array.length-1];
    }

    public static int minNumberInRotateArray2(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length -1;
        int mid = (right - left)/2;
        while (left < right){
            if (array[mid] > array[mid] + 1 && mid < right-1){
                return array[mid + 1];
            }
            if (array[mid -1] > array[mid] && mid-1 >= left){
                return array[mid];
            }
            if (array[mid] > array[left]){
                left = mid;
                mid = left + (right - left)/2;
            }else if (array[mid] < array[right]){
                right = mid;
                mid = left + (right - left)/2;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] num = {3,4,5,1,2};
        minNumberInRotateArray2(num);
    }
}
