package medium;

import java.util.Arrays;

/**
 * @program:
 * @description:
 * O(n log n)的时间复杂度解决以下问题
 * 给定未排序的整数数组，找到最长的增加子序列的长度。
 *
 * 例：
 *
 * 输入： [10,9,2,5,3,7,101,18]
 * 输出： 4
 *  说明：增长最长的子序列是[2,3,7,101]，因此长度为4。
 *  新建一个数组A，遍历输入数组B，并且定义一个指针i，如果数组B的值大于A[i]的值，那么就把B的当前值放在i++的位置，再执行i++；
 *  如果数组B的值小于A[i]的值，就找数组B的当前值应该出现在数组中的那一个位置（在该位置前的数字一定都比这个数大，因此还是升序排序的一个子序列），
 *  并把那个位置的值用数组B中的当前值来替换掉；
 * @author: Song
 * @create: Created in 2019-04-09 14:44
 * @Modified by:
 **/
public class Code_300_LongestIncreasingSubsequence {

    //方法1；
    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    //[10,9,2,5,3,7,101,18]
    public static int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1])
                increasingSequence[len++] = nums[i];
            else {
                int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                increasingSequence[position] = nums[i];
            }
        }
        return len;
    }

    //方法2
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;

            for(int x : nums) {
                int i = Arrays.binarySearch(dp, 0, len, x);
                if(i < 0) i = -(i + 1);
                dp[i] = x;
                if(i == len) len++;
            }

            return len;
        }
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int maxLength = 1;
        if (nums.length > 3){
            process(nums, 0, nums.length -1);
            int index = 0;
            while (index + 1 <= nums.length -1 && nums[index] < nums[index + 1]){
                maxLength ++;
                index ++;
            }
        }else {
            if (nums.length == 1){
                return 1;
            }else if (nums.length == 2){
                if (nums[0] < nums[1]){
                    return 2;
                }else {
                    return 1;
                }
            }else {
                if (nums[0] < nums[1] && nums[1] < nums[2]){
                    return 3;
                }else if (nums[0] < nums[1] ){
                    return 2;
                }else if (nums[1] < nums[2]){
                    return 2;
                }else {
                    return 1;
                }
            }
        }

        return maxLength;
    }
    public static void process(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        process(nums, start,mid);
        process(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int start, int mid, int end){
        if (end - start >= 3){
            int[] help = new int[end - start + 1];
            int i = 0;
            int left = mid;
            int right = mid + 1;
            int m = start;
            while (start <= left && right <= end){
                if (nums[start] < nums[right]){
                    help[i] = nums[start];
                    start ++;
                    i++;
                }else if (nums[start] > nums[right]){
                    boolean flag = false;
                    while (right + 1 <= end && nums[right] < nums[right + 1]){
                        help[i] = nums[right];
                        right++;
                        i++;
                        flag  =true;
                    }
                    if (flag){
                        help[i] = nums[right];
                        i++;
                        right ++;
                    }

                    for (int j = start; j <= left; j++){
                        help[i] = nums[start];
                        start ++;
                        i++;
                    }
                    for (int j = right; j <= end; j++){
                        help[i] = nums[right];
                        right++;
                        i++;
                    }
                }else {
                    help[i] = nums[start];
                    start ++;
                    i++;
                }
            }
            while (start <= left){
                help[i] = nums[start];
                start++;
                i++;
            }
            while (right <= end){
                help[i] = nums[right];
                right++;
                i++;
            }
            for (int k = m; k <= end; k++){
                nums[k] = help[k - m];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
