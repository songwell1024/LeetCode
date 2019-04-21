package TypicalExample;

import java.util.ArrayList;

/**
 * @ClassName: Code_01
 * @Description:
 * 1 到 n 的全排列
 * 无重复的数组中的全排列
 * @Author: WilsonSong
 * @Date: 2019/4/20 17:52
 * @Version 1.0
 **/
public class Code_01 {
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] help;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists  = getAllRange(3);

        System.out.println(lists);
    }

    /*
     * @Author: WilsonSong
     * @Description: 获取全排列
     * @Date: 18:44 2019/4/20
     * @Param: [n]
     * @return java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
     **/
    public static ArrayList<ArrayList<Integer>> getAllRange(int n){
        int[] num = new int[n];
        for (int i = 0; i < n; i ++){
            num[i] = i + 1;
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//        process(num, 0, lists);
//        return lists;

        visited = new boolean[n];
        help = new int[n];
//        dfsByList(num, lists, 0);
        dfsByArray(num, 0, lists);
        return lists;
    }

    //交换然后递归的方式来做
    public static void process(int[] num, int start,ArrayList<ArrayList<Integer>> lists){
        if (start == num.length){
           ArrayList<Integer> list = new ArrayList<>();
            for (int n : num){
                list.add(n);
            }
            lists.add(list);
            return;
        }

        for (int i = start; i < num.length; i++){
            swap(num,i, start);
            process(num, start + 1, lists);
            swap(num, i, start);
        }
    }

    public static void swap(int[] num, int i, int j){
        int help = num[i];
        num[i] = num[j];
        num[j] = help;
    }

    //List的方式实现bfs
    public static void dfsByList(int[] num, ArrayList<ArrayList<Integer>> lists, int start){

        if (start == num.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++){
            if (!visited[i]){
                visited[i] = true;
                list.add(num[i]);
                dfsByList(num, lists,start + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    //array的方式实现bfs
    public static void dfsByArray(int[] num, int start,ArrayList<ArrayList<Integer>> lists){
        if (start == num.length){
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : help){
                list.add(n);
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < num.length; i++){
            if (!visited[i]){
                visited[i] = true;
                help[start] = num[i];
                dfsByArray(num, start + 1, lists);
                visited[i] = false;
            }
        }
    }





}
