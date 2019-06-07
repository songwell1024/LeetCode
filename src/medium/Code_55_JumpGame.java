package medium;

/**
 * @program: LeetCode
 * @description:
 * 给定一个非负整数数组，您最初定位在数组的第一个索引处。
 *
 * 数组中的每个元素表示该位置的最大跳转长度。
 *
 * 确定您是否能够到达最后一个索引。
 * @author: Song
 * @create: 2019-06-03 20:41
 **/
public class Code_55_JumpGame {

    //贪心
    //从max表示从i之前开始的某个位置开始最远能够跳到的位置，当i位置的值大于max的时候，就意味着
    //跳不到这个位置
    //max 的值永远取值为从0-i位置直接能够跳到的最远的位置
    //当能够遍历完整个数组的时候就意味着肯定是能够跳到最后了
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }

    //DP
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        for (int i = 0; i < n; i++){
            jump[i] = false;
        }
        jump[n-1]=true;

        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=nums[i] && i+j<n;j++)
            {
                if(jump[i+j]==true)
                {
                    jump[i]=true;
                    break;
                }
            }
        }
        return jump[0];
    }
}
