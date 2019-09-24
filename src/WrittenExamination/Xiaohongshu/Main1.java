package WrittenExamination.Xiaohongshu;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/18 15:54
 * @Version 1.0
 **/
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        int[] target = new int[n];
        search(nums, dp, target);
        System.out.println(dp[n-1] + " " + target[n-1]);
    }

    public static void search(int[] array, int[] dp, int[] num) {
        int n = array.length;
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i < n; i++){
            if (array[i] + dp[i-2] < dp[i-1]) {
                dp[i] = dp[i-1];
                num[i] = num[i-1];
            }else if (array[i] + dp[i-2] > dp[i-1]){
                dp[i] = array[i] + dp[i-2];
                num[i] = num[i-2] + 1;
            }  else {
                if (num[i-2] + 1 <= num[i-1]){
                    dp[i] = array[i] + dp[i-2];
                    num[i] = num[i-2] + 1;
                } else {
                    dp[i] = dp[i-1];
                    num[i] = num[i-1];
                }
            }
        }
    }
}