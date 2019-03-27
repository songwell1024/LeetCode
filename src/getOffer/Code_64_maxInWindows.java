package getOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program:
 * @description:
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @author: Song
 * @create: Created in 2019-03-27 18:09
 * @Modified by:
 **/
public class Code_64_maxInWindows {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size >= num.length || size <= 0){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int left = 0;
        int right = size - 1;
        for (int i = 0; i<= right; i++){
           queue.add(num[i]);
        }
        list.add(queue.peek());
        left++;
        right++;
        while (right < num.length){
           queue.remove(num[left - 1]);
           queue.add(num[right]);
           list.add(queue.peek());
           left++;
           right++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        maxInWindows(nums, 3);
    }


    /**
     * 题目：滑动窗口的最大值
     * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
     *     原则：
     *     对新来的元素k，将其与双端队列中的元素相比较
     *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     *     队列的第一个元素是滑动窗口中的最大值
     */
    public class P65_滑动窗口的最大值 {

        public ArrayList<Integer> maxInWindows(int [] num, int size)
        {
            ArrayList<Integer> ret = new ArrayList<>();
            if (num == null) {
                return ret;
            }
            if (num.length < size || size < 1) {
                return ret;
            }

            LinkedList<Integer> indexDeque = new LinkedList<>();
            for (int i = 0; i < size - 1; i++) {
                while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                    indexDeque.removeLast();
                }
                indexDeque.addLast(i);
            }

            for (int i = size - 1; i < num.length; i++) {
                while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                    indexDeque.removeLast();
                }
                indexDeque.addLast(i);
                if (i - indexDeque.getFirst() + 1 > size) {
                    indexDeque.removeFirst();
                }
                ret.add(num[indexDeque.getFirst()]);
            }
            return ret;
        }
    }
}
