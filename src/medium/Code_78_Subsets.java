package medium;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program:
 * @description:
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author: Song
 * @create: Created in 2019-02-19 21:39
 * @Modified by:
 **/
public class Code_78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        process(nums, 0, lists, new ArrayList<Integer>());
        return lists;
    }

    public static void process(int[] nums, int start, List<List<Integer>> lists, List<Integer> list){
        if (start == nums.length){
            lists.add(new ArrayList<>(list));    //这里的意思是把这个list赋值给一个新的list
//            // 此时B对象相当与A对象的引用，而并不是将A对象的值单纯的传递给B对象。
//            即：B对象的操作将直接改变A对象。如B.add("3");结果A中也包含了“3”；所以这里不能用等号直接赋值
//            List<Integer> list1 = new ArrayList<>(list);
//            list1 = list;
//            lists.add(list1);
            return;
        }
        process(nums,start + 1, lists, list);
        list.add(nums[start]);
        process(nums, start + 1, lists, list);
        list.remove(list.size()-1);  //为了保持list的不变性，所以要把最新添加进来的值删除
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);

        System.out.println("1");

    }

}
