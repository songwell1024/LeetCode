package Easy;

/**
 * 你是一个专业的强盗，计划在街上抢劫房屋。每个房子都藏着一定数量的钱，阻止你抢劫他们的唯一限制因素是相邻的房屋有连接的安全系统，
 * 如果两个相邻的房子在同一个晚上被闯入，它将自动联系警方。

 给出一个代表每个房子的金额的非负整数列表，确定今晚可以抢劫的最大金额而不警告警察。
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_198_HouseRobber {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length <=2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);    //这一步很重要，当时就出错在这里了，因为第二个的值的话应该选前两个中较大的那个值，因为有可能是第二个没选然后选了第一
                                                //当时就是这个地方出问题了，当是这个例子时[2,1,1,2]
        for (int i = 2; i< nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args){

        int[] nums = {2,1,2,1};
        System.out.println(rob(nums));

    }
}
