package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 包含重复元素的数组的所有子数组
 * @author: Song
 * @create: 2019-07-06 16:15
 **/
public class Code_90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums == null){
            return list;
        }
        process(nums,0, new ArrayList<Integer>(), list);
        return list;

    }

    public void process(int[] nums, int start, ArrayList<Integer> tmpList,List<List<Integer>> list){
        list.add(new ArrayList<>(tmpList));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            tmpList.add(nums[i]);
            process(nums, i + 1, tmpList, list);
            tmpList.remove(tmpList.size() -1);
        }
    }
}
