package WrittenExamination.Xiaohongshu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/18 15:26
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] strs = in.split(" ");
        int target = Integer.valueOf(strs[0]);
        String[] str = strs[1].substring(1, strs[1].length()-1).split(",");
        int[] nums = new int[str.length];
        for (int i=0; i<str.length; i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        List<List<Integer>> lists = combinationSum(nums, target);
        System.out.println(lists.size());

    }
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
