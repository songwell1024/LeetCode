package medium;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @ClassName: Code_56_MergeIntervals
 * @Description:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * @Author: WilsonSong
 * @Date: 2019/4/24 15:19
 * @Version 1.0
 **/
public class Code_56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null){
            return intervals;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 2; j++){
                list.add(intervals[i][j]);
            }
            lists.add(list);
        }
        lists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(lists.get(0));
        for (int i = 1; i < lists.size(); i++){
            ArrayList<Integer> list = res.get(res.size() -1);
            if (list.get(1) >= lists.get(i).get(0)){
                res.get(res.size() -1).set(1, Math.max(list.get(1), lists.get(i).get(1)));
            }else {
                res.add(lists.get(i));
            }
        }
        int[][] num = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++){
            for (int j = 0; j < 2; j++){
                num[i][j] = res.get(i).get(j);
            }
        }
        return num;
    }
}
