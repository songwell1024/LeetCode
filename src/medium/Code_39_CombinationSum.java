package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description: 找到数组中等于目标值的所有的组合
 * 数组中的数据可以重复使用
 * @author: Song
 * @create: Created in 2019-02-22 09:26
 * @Modified by:
 **/
public class Code_39_CombinationSum {
    //超时，并且有很多的重复项
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(lists, candidates, target,0, list);
        return lists;
    }

    public static void process(List<List<Integer>> lists, int[] candidates, int target, int start, List<Integer> list){
        if (start >= candidates.length || target < 0){
            return;
        }
        if (start < candidates.length && target == 0){
            if (!lists.contains(list)){
                lists.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = 0; i < target /candidates[start]; i ++){
            list.add(candidates[start]);
            process(lists, candidates, target - candidates[start], start, list);
            list.remove(list.size() -1);
        }
        process(lists, candidates, target, start + 1, list);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process2(lists, candidates, target,0, list);
        return lists;
    }

    public static void process2(List<List<Integer>> lists, int[] candidates, int target, int start, List<Integer> list){
        if (start >= candidates.length || target < 0){
            return;
        }
        if (start < candidates.length && target == 0){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){           //值得注意的地方在这里
            list.add(candidates[i]);
            process2(lists, candidates, target - candidates[i], i, list);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args){
        int[] nums = {8,7,4,3};
        combinationSum(nums, 11);
    }
}
