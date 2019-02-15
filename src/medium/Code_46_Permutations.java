package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: Given a collection of distinct integers, return all possible permutations.
 * @author: Song
 * @create: Created in 2019-01-17 19:48
 * @Modified by:
 **/
public class Code_46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        premuteProcess(nums, resList, 0);
        return resList;
    }

    public void premuteProcess(int[] nums, List<List<Integer>> lists,int start){
        if (start >= nums.length){
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }

            lists.add(list);
        }else {
            for (int i= start; i < nums.length; i++){
                swap(nums, start, i);
                premuteProcess(nums, lists, start + 1);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int helpIndex = nums[i];
        nums[i] = nums[j];
        nums[j] = helpIndex;
    }

}
