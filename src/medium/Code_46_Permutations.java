package medium;

import java.util.Iterator;
import java.util.LinkedList;
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
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            list.add(nums[i]);
            lists.add(list);
        }

        while (((LinkedList<List<Integer>>) lists).peek().size() != nums.length){
            for (int i = 0; i < nums.length; i++){
               for (int j = 0; j < nums.length; j++){
                   if (!lists.get(j).contains(nums[i])){
                       lists.get(j).add(nums[i]);
                   }
               }
            }
        }
        return lists;

    }


}
