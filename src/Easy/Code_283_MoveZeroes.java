package Easy;

/**
 * 给定一个数组nums，写一个函数将所有0的移动到它的末尾，同时保持非零元素的相对顺序。
 * @author WilsonSong
 * @date 2019/1/4/004
 */
public class Code_283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                for (int j = i + 1; j < nums.length; j ++){
                    if (nums[j] != 0){
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int index = nums[i];
        nums[i] = nums[j];
        nums[j] = index;
    }

    public static void moveZeroes2(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }

        int insertPos = 0;
        for(int num: nums){
            if(num != 0){
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length){
            nums[insertPos++] = 0;
        }

    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeroes2(nums);

        for (int num : nums){
            System.out.println(num);
        }
    }


}
