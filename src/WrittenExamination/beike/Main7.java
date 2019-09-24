package WrittenExamination.beike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main7
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/23 20:49
 * @Version 1.0
 **/
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] W = new int[N+1];
        int sum = 0;
        for (int i=1; i<=N; i++){
            W[i] = scanner.nextInt();
            sum += W[i];
        }
        int c = sum/2;
        int[] dp = new int[c + 1];
        boolean[][] used = new boolean[N+1][c + 1];
        for (int i=1; i<N+1; i++){
            for (int j=c; j>=W[i]; j--){
                if (dp[j] < dp[j - W[i]] + W[i]){
                    dp[j] = dp[j - W[i]] + W[i];
                    used[i][j] = true;
                }
            }
        }
        int i = N;
        int j = c;
        int numbers = 0;
        while (i > 0){
            if (used[i][j]){
                numbers ++;
                j -= W[i];
            }
            i--;
        }
        List<List<Integer>> lists = combinationSum2(W,c);
        int min = Integer.MIN_VALUE;
//        for (int k = 0; k< lists.size(); k++){
//            min =
//        }
        System.out.println((sum - dp[c] * 2) + " " + Math.abs(N - numbers*2));
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
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
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
