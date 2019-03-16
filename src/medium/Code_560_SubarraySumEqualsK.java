package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description: 给定一个整数数组和一个整数k，您需要找到其总和等于k的连续子数组的总数。
 * 暴力解决就是直接遍历即可，但是暴力O(n2)
 * 从解决方案1中，我们知道解决此问题的关键是SUM[i, j]。因此，如果我们知道的SUM[0, i - 1]和SUM[0, j]，那么我们就可以轻松搞定SUM[i, j]。为了实现这一点，
 * 我们只需要遍历数组，计算当前总和并保存所有看到PreSumHashMap的数量。时间复杂度O（n），空间复杂度O（n）。
 * @author: Song
 * @create: Created in 2019-03-05 17:00
 * @Modified by:
 **/
public class Code_560_SubarraySumEqualsK {

    //时间复杂度 o（n）， 空间复杂度o(n)
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);   //就是当sum == k时，需要 + 1， map中存的是0 - i 的和

        for (int i= 0; i < nums.length; i ++){
            sum += nums[i];
            if (map.containsKey(sum - k)){//存在 0~j = 0 ~i - k那么i~j = k
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); //map中有几个连续的子数组的是sum
        }
        return res;
    }
}
