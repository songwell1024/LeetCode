package Easy;

/**
 * Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 * @author WilsonSong
 * @date 2019/1/9/009
 */
public class Code_189_RotateArray {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int l = nums.length-1;

        int s = k -1;
        int e = 0;

        while (s >= 0){
            swap(nums, l-s, e);
            e++;
            s--;
        }
        s = k -1;
        if (k < nums.length - k){
            for (int i = l- k; i >= k; i--){
                int index = i;
                while (s >= 0){
                    swap(nums, index, index +1);
                    index ++;
                    s--;
                }
                s = k -1;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int index = 0;
        index = nums[i];
        nums[i] = nums[j];
        nums[j] = index;
    }

    public static void main(String[] args){

        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 4);
        System.out.println('a');
    }

}
