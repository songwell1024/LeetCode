package medium;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 给定可能包含重复项的数字集合，返回所有可能的唯一排列。
 * @author: Song
 * @create: 2019-07-06 16:17
 **/
public class Code_47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums == null){
            return list;
        }
        process(nums, list,0);
        return list;

    }

    public void process(int[] nums, List<List<Integer>> list, int start){
        if (start >= nums.length){
            List<Integer> tmpList =new ArrayList<>();
            for (int num : nums){
                tmpList.add(num);
            }
            list.add(tmpList);
        }else {
            Set<Integer> appeared = new HashSet<>();
            for (int i = start; i < nums.length; i++){
               if (appeared.add(nums[i])){
                   swap(nums, start,i);
                   process(nums, list, start +1);
                   swap(nums, start, i);
               }

             }
        }
    }
    public void swap(int[] nums, int i, int j){
        int helpIndex = nums[i];
        nums[i] = nums[j];
        nums[j] = helpIndex;
    }
}
