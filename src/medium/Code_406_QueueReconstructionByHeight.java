package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program:
 * @description: 假设您有一个随机的人员列表。每个人用一对整数来描述(h, k)，
 * 其中h是人的高度，并且k是这个人的高度大于或等于的人数h。编写算法来重建队列。
 * @author: Song
 * @create: Created in 2019-01-15 15:11
 * @Modified by:
 **/
public class Code_406_QueueReconstructionByHeight {
//
//    static class people {
//        int h;
//        int k;
//
//        public people(int h, int k){
//            this.k = k;
//            this.h = h;
//        }
//    }
//
//    public static class peopleComparatorByH implements Comparator<people>{
//
//        @Override
//        public int compare(people o1, people o2) {
//            return (o1.h  - o2.h);
//        }
//    }
//
//    public static class peopleComparatorByK implements Comparator<people>{
//
//        @Override
//        public int compare(people o1, people o2) {
//            return o1.k + o1.h - o2.k -o2.h;
//        }
//    }
//
//    public static int[][] reconstructQueue(int[][] people) {
//
//        if (people == null || people.length <=0 || people[0].length < 0){
//            return null;
//        }
//        PriorityQueue<people> hQueue = new PriorityQueue<>(new peopleComparatorByH());
//        PriorityQueue<people> kQueue = new PriorityQueue<>(new peopleComparatorByK());
//
//        for (int i = 0; i< people.length; i++){
//            hQueue.add(new people(people[i][0], people[i][1]));
//            kQueue.add(new people(people[i][0], people[i][1]));
//        }
//
//        int[][] res = new int[people.length][people[0].length];
//
//        for (int i = 0; i < res.length; i++){
//            people p = kQueue.poll();
//            PriorityQueue<people> helpQueue= new PriorityQueue<>(new peopleComparatorByH());
//            if (!kQueue.isEmpty()){
//                while ((kQueue.peek().k + kQueue.peek().h) == (p.k + p.h)){
//                    if (kQueue.peek().h < p.h && kQueue.peek().k <=i){
//                        people help = p;
//                        p = kQueue.poll();
//                        helpQueue.add(help);
//                    }else {
//                        break;
//                    }
//                }
//            }
//
//            while (!helpQueue.isEmpty()){
//                kQueue.add(helpQueue.poll());
//            }
//            res[i][0] = p.h;
//            res[i][1] = p.k;
//        }
//        return res;
//    }
//
//    public static void main(String[] args){
//        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//        reconstructQueue(people);
//    }

//    public int[][] reconstructQueue(int[][] people) {
//
//    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }




}
