package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @program:
 * @description: 给定一个char数组表示CPU需要执行的任务。它包含大写字母A到Z，其中不同的字母代表不同的任务。任务可以没有原始订单完成。每项任务都可以在一个时间间隔内完成。对于每个间隔，CPU可以完成一个任务或只是空闲。
 *
 * 但是，有一个非负的冷却间隔n意味着在两个相同的任务之间，必须至少有n个间隔，CPU正在执行不同的任务或只是空闲。
 *
 * 您需要返回CPU将完成所有给定任务所需的最少间隔数
 *
 * partCount = count(A) - 1
 * emptySlots = partCount * (n - (count of tasks with most frequency - 1))
 * availableTasks = tasks.length - count(A) * count of tasks with most frenquency
 * idles = max(0, emptySlots - availableTasks)
 * result = tasks.length + idles
 * @author: Song
 * @create: Created in 2019-03-03 18:58
 * @Modified by:
 **/
public class Code_621_TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int res = 0;
        if (tasks == null || tasks.length == 0){
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (char c : tasks){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
            set.add(c);
        }

        while (!map.isEmpty()){
            int index = 0;
            for (char c : set) {
                if (map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0){
                        map.remove(c);
                    }
                    index++;
                    if (index == n + 1){
                        break;
                    }
                }
            }
            if (!map.isEmpty()){
                res += n + 1 - index;
            }
        }
        return res + tasks.length;

    }

    public int leastInterval2(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        char[] chars = {'A','A','A','B','B','B','B','B','B'};
        leastInterval(chars,2);
    }
}
