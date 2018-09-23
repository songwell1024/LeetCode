package Easy;

/**
 * 给定数组nums和值val，在适当位置删除该值的所有实例并返回新长度。
 不要为另一个数组分配额外的空间，你必须这样做修改输入数组就地用O（1）额外的内存。
 元素的顺序可以改变。你留下的新长度并不重要。
 * @author WilsonSong
 * @date 2018/9/23/023
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int cur = 0;
        for (int i  = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[cur] = nums[i];
                System.out.println(nums[cur]);
                cur ++;
            }
        }
        return cur;
    }


    public static void main(String[] args){
        int[] nums = {1,3,2,2,3};
        System.out.println(removeElement(nums,4));
    }
}
