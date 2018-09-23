package Easy;

/**
 * 给定排序数组和目标值，如果找到目标，则返回索引。如果没有，请返回索引按顺序插入的索引。
 您可以假设数组中没有重复项。
 * @author WilsonSong
 * @date 2018/9/23/023
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target){
            return 0;
        }
        for (int i= 1; i< nums.length; i++){
            if (nums[i]  == target){
                return i;
            }else {
                if (nums[i] > target && nums[i-1] < target){
                    return i;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args){
        int[] nums = {3};
        System.out.println(searchInsert(nums,3));
    }
}
