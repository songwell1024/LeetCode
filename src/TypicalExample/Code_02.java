package TypicalExample;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName: Code_02
 * @Description:
 * 数组中有重复元素的全排列
 * @Author: WilsonSong
 * @Date: 2019/4/20 20:57
 * @Version 1.0
 **/
public class Code_02 {
    static int[] visited;
    static int[] help;
    static boolean[] flag;
    public static void main(String[] args) {
        int[] num = {1,1,1,2,2};
        ArrayList<ArrayList<Integer>> lists = getAllRange(num);
        System.out.println(lists);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    //递归的方式
    public static ArrayList<ArrayList<Integer>> getAllRange(int[] num){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//        process(num,0, lists);
//        return lists;
        visited = new int[num.length];
        help = new int[num.length];
        flag = new boolean[num.length];
        for (int n : num){
            visited[n] ++;
        }
        dfsByList(num,0, lists);
//        dfsByArray(num,0, lists);
//        dfsByArraySort(num,0, lists);
        return lists;
    }

    public static void process(int[] num, int start, ArrayList<ArrayList<Integer>> lists){
        if (start == num.length){
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : num){
                list.add(n);
            }
            lists.add(list);
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = start; i < num.length; i++){
            if (!hashSet.contains(num[i])){
                hashSet.add(num[i]);
                swap(num,i, start);
                process(num,start + 1, lists);
                swap(num, i, start);
            }
        }

    }

    public static void swap(int[] num, int i, int j){
        int help = num[i];
        num[i] = num[j];
        num[j] = help;
    }

    //dfs的方式, 计数器的方式
    public static void dfsByList(int[] num, int start,ArrayList<ArrayList<Integer>> lists){
        if (start == num.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < visited.length; i++){
            if (visited[i] > 0){
                visited[i] --;
                list.add(i);
                dfsByList(num, start + 1, lists);
                visited[i] ++;
                list.remove(list.size() - 1);
            }

        }

    }

    //dfs的方式, 计数器的方式
    public static void dfsByArray(int[] num, int start,ArrayList<ArrayList<Integer>> lists){
        if (start == num.length){
            ArrayList<Integer> list =new ArrayList<>();
            for (int n : help){
                list.add(n);
            }
            lists.add(list);
            return;
        }

        for (int i = 0; i < visited.length; i++){
            if (visited[i] > 0){
                visited[i] --;
                help[start] = i;
                dfsByArray(num, start + 1, lists);
                visited[i] ++;
            }

        }
    }

    //dfs 要想保证不重复则保证回溯回去的那个元素和下一个要遍历的元素是不相同的，相同的
    //话就没有遍历的必要了

    public static void dfsByArraySort(int[] num, int start,ArrayList<ArrayList<Integer>> lists){
        if (start == num.length){
            ArrayList<Integer> list =new ArrayList<>();
            for (int n : help){
                list.add(n);
            }
            lists.add(list);
            return;
        }
        int last = -1;
        for (int i = 0; i < num.length; i++){
            if (!flag[i] && last != num[i]){
                flag[i] = true;
                help[start] = num[i];
                last = num[i];
                dfsByArraySort(num,start+1, lists);
                flag[i] = false;
            }

        }
    }
}
