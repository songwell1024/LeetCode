package WrittenExamination.Aiqiyi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/8 15:41
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] color = new int[m+n];
        for (int i = 0; i< n; i++){
            color[i] = 0;  //0表示红球
        }
        for (int i = n; i < n+m;i++){
            color[i] = 1;   //1表示蓝球
        }
        List<List<Integer>> lists = permuteUnique(color);
        int res = 0;
        for (int i = 0;i< lists.size();i++){
            if (isAWin(lists.get(i),n)){
                res++;
            }
        }
        double sum = res;
        String format = new DecimalFormat("0.00000").format((sum/ lists.size()));
        System.out.println(format);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean isAWin(List<Integer> list, int n){
        for (int i = 0; i< list.size(); i++){
            if (n == 0){
                return false;
            }
            if (list.get(i) == 0){
                return true;
            }else {
                i++;
                if (i < list.size() && list.get(i) == 0){
                    return false;
                }
                i++;
                if (i < list.size() && list.get(i) == 0){
                    n--;
                }
            }
        }
        return false;
    }
}
