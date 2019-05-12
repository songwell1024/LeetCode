package medium;

/**
 * @program: LeetCode
 * @description:
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * 思路：先二分找左边界，然后二分找有边界
 * 二分找左边界的话：如果mid的值小于target,接下来就从mid+1开始往右找
 * 如果mid的值等于target，就从左边界开始往右找找到mid的位置
 * 如果mid的值大于target，就从左边界开始往右找找到mid的位置
 * 直到找到左边界与有边界相等，此时的值就是target在数组中对应的左边界
 * 找有边界同理
 * @author: Song
 * @create: 2019-05-05 19:01
 **/
public class Code_34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return ans;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        int left = low;
        if(low < 0 || low >= nums.length || nums[low] != target) return new int[]{-1,-1};
        high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return new int[]{left,high};
    }

}
