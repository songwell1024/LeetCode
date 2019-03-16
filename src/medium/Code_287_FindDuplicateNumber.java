package medium;

import java.util.HashSet;

/**
 * @program:
 * @description: 找到数组中的重复的数，只有一个重复的数
 * 时间复杂度 O(n2), 空间复杂度 O(1)
 *
 * 对于数组 A = [2,6,4,1,3,1,5]
 * index 0 , 1, 2, 3, 4, 5, 6
 * value:2, 6, 4, 1, 3, 1, 5
 *
 * 索引是什么？ 索引是指针的相对位置/偏移量
 * 那么value 是什么？ 下一个位置的地址
 * 那么这个数组就可以转换为 : 0 - > 2 - > 4 -> 3 -> 1 -> 6 -> 5-> [1- >6-> 5 ->1 链表环] 可以看到这就是一个有环的链表
 * slow = nums[slow] 的含义就是指针向右移动一步 等价于slow = slow.next
 * fast = nums[nums[fast]] 就是移动两步 等价于fast = fast.next.next
 * 快速和慢速使用两个指针。快速的每次前进两步，而慢速每次只前进一步。当慢= =快时，它们必须满足相同的项目。
 * 实际上，它们在一个圆圈中相遇，当从nums [0]访问数组时，重复的数字必须是圆的入口点。
 * @author: Song
 * @create: Created in 2019-02-20 20:14
 * @Modified by:
 **/
public class Code_287_FindDuplicateNumber {
    /**
     * 这里的时间复杂度O(n)，空间复杂度O（n）
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null){
            return -1;
        }

        int fast = nums[nums[0]];
        int slow = nums[0];

        while (fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }


    public int findDuplicate1(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            if (hashSet.contains(num)){
                return num;
            }else {
                hashSet.add(num);
            }
        }
        return 0;
    }
}
