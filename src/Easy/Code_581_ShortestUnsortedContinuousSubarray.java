package Easy;

/**
 * @program:
 * @description: 给定一个整数数组，您需要找到一个连续的子数组，如果您只按升序对此子数组进行排序，那么整个数组也将按升序排序。
 *您需要找到最短的子阵列并输出其长度。
 * @author: Song
 * @create: Created in 2019-01-14 19:09
 * @Modified by:
 **/
public class Code_581_ShortestUnsortedContinuousSubarray {

    //不管升序还是降序只要是排序就可以
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int res = 0;
        int start = 0;
        int end = nums.length -1;

        while (start < nums.length){
            if (isMaxPre(nums, start)){
                start ++;
            }else {
                break;
            }

        }

        while (end >= 0){
            if (isMinPos(nums, end)){
                end --;
            }else {
                break;
            }
        }
        if (end > start){
            res = end - start + 1;
        }

        start = 0;
        end = nums.length -1;

        while (start < nums.length){
            if (isMinPre(nums, start)){
                start ++;
            }else {
                break;
            }

        }

        while (end >= 0){
            if (isMaxPos(nums, end)){
                end --;
            }else {
                break;
            }
        }
        if (end > start){
            res =Math.min( end - start + 1, res);
        }else {
            res = 0;
        }
        return res;

    }

    public static int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int res = 0;
        int start = 0;
        int end = nums.length -1;

        while (start < nums.length){
            if (isMinPre(nums, start)){
                start ++;
            }else {
                break;
            }

        }

        while (end >= 0){
            if (isMaxPos(nums, end)){
                end --;
            }else {
                break;
            }
        }
        if (end > start){
            res = end - start + 1;
        }

        return res;
    }

    public static boolean isMaxPre(int[] nums, int i){
        int num = nums[i];
        while (i < nums.length-1){
            if (num >= nums[i +1]){
                i++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isMaxPos(int[] nums, int i){
        int num = nums[i];
        while (i > 0){
            if (num >= nums[i - 1]){
                i--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isMinPre(int[] nums, int i){
        int num = nums[i];
        while (i < nums.length -1){
            if ( num <= nums[i +1]){
                i++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isMinPos(int[] nums, int i){
        int num = nums[i];
        while (i > 0){
            if (num <= nums[i - 1]){
                i--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] nums = {1,3,2,3,3};
        System.out.println(findUnsortedSubarray2(nums));
    }
}
