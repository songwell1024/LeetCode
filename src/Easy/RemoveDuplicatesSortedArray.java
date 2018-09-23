package Easy;

/**
 * @author WilsonSong
 * @date 2018/9/14/014
 */
public class RemoveDuplicatesSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums == null){
            return 0;
        }
        int index = 0;
        for (int cur = 1; cur < nums.length; cur++){
            if (nums[cur] != nums[index]){
                nums[++index] = nums[cur];
            }
        }
        return index+1;
    }

    public static void main(String[] args){
        int[] data = {1,1,2,2};
        System.out.println(removeDuplicates(data));
    }
}
