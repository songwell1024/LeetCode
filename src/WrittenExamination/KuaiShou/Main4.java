package WrittenExamination.KuaiShou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 21:21
 * @Version 1.0
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i< N;i++){
           nums[i] = sc.nextInt();
        }
        System.out.println(calArithmeticSequence(nums));
    }


    public static int calArithmeticSequence(int[] nums){
        int length = nums.length;
        if(length == 0) return 0;
        Arrays.sort(nums);
        int diffMax = nums[length - 1] - nums[0];
        int[][] dp = new int[length][diffMax + 1];
        for(int i = 0; i < length; i++)
            for(int j = 0; j <= diffMax; j++)
                dp[i][j] = 1;
        int longestLength = 1;
        for(int i = 1; i < length; i++)
            for(int j = i - 1; j >= 0; j--){
                int temp = nums[i] - nums[j];
                dp[i][temp] = dp[j][temp] + 1;
                longestLength = Math.max(longestLength, dp[i][temp]);
            }
        return longestLength;
    }
}
