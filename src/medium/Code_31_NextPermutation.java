package medium;

import java.util.Arrays;

/**
 * @ClassName: Code_31_NextPermutation
 * @Description:
 * 实现下一个排列，它将数字重新排列到字典上的下一个更大的数字排列。
 *
 * 如果这种安排不可能，则必须将其重新排列为尽可能低的顺序（即按升序排序）。
 *
 * 替换必须就地，并且仅使用恒定的额外内存。
 *
 * 这里有些例子。输入位于左侧列中，其相应的输出位于右侧列中。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @Author: WilsonSong
 * @Date: 2019/6/8 19:06
 * @Version 1.0
 **/
public class Code_31_NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        int index = nums.length-1;
        while (index > 0 && nums[index] <= nums[index -1]){
            index --;
        }
        if (index == 0) {
            Arrays.sort(nums);
        }else {
            index = index -1;
            for (int i = nums.length -1; i > index; i--){
                if (nums[i] > nums[index]){
                    swap(nums, i, index);
                    break;
                }
            }
            Arrays.sort(nums, index + 1, nums.length);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int help = nums[i];
        nums[i] = nums[j];
        nums[j] = help;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,7,5,4,3,2,2,1};
        nextPermutation(nums);

    }
}
