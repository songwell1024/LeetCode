package Easy;

/**
 *
 * 给定两个排序的整数数组nums1和nums2，将nums2合并为nums1作为一个排序的数组。
 注意：
 在nums1和nums2中初始化的元素数分别为m和n。
 您可以假设nums1有足够的空间（大小大于或等于m + n）来保存nums2中的其他元素。
 例：
 输入：
 nums1 = [1,2,3,0,0,0]，m = 3
 nums2 = [2,5,6]，n = 3
 产量：  [1,2,2,3,5,6]
 * @author WilsonSong
 * @date 2018/9/27/027
 */
public class MergeSortedArray {
    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        for (int i = 0; i< nums1.length; i++){
            if (k < n && i<m){
                if (nums1[i] > nums2[k]){
                    move(nums1, i);
                    nums1[i] = nums2[k];
                    k++;
                    m++;
                }
            }else if (k<n){
                nums1[i] = nums2[k];
                k++;
            }
        }
    }

    public static void move(int[] nums, int i){
        for (int j = nums.length-1; j>i; j--){
            nums[j] = nums[j-1];
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge( nums1, 3, nums2, 3);
    }


}
