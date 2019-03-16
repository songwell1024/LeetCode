package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @program:
 * @description: 找到未排序数组中的第k个最大元素。请注意，它是排序顺序中的第k个最大元素，而不是第k个不同元素。
 * 这道题目是啥吗。
 * @author: Song
 * @create: Created in 2019-02-25 15:26
 * @Modified by:
 **/
public class Code_215_KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null){
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length -1 - k];
    }

    public int findKthLargest2(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();    //每次弹出的是最大的数
            }
        }
        return pq.peek();
    }


}
