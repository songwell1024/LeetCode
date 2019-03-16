package medium;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-03-07 15:38
 * @Modified by:
 **/
public class Code_75_SortColors {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int left = 0;
        int right = nums.length -1;
        int index = 0;
        while (index <= right){
            if (nums[index] < 1){
                swap(index, left,nums);
                left ++;
                if (index <= left){
                    index = left;
                }
            }else if (nums[index] > 1){
                swap(index, right, nums);
                right --;
            }else {
                index ++;
            }
        }
    }

    public static void swap(int i, int j, int[] nums){
        int help = nums[i];
        nums[i] = nums[j];
        nums[j] = help;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0,0,0,2,2};
        sortColors(nums);
    }
}
