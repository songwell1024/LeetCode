package WrittenExamination.Others;

import java.util.*;
import java.util.ArrayList;
public class Main2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Float>> lists = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        float d = sc.nextFloat();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Float> list = new ArrayList<>();
            list.add(sc.nextFloat());
            list.add(sc.nextFloat());
            lists.add(list);
        }

        for (int i = 0; i < lists.size(); i++) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = i + 1; j < lists.size(); j++) {
                if (Math.sqrt(Math.pow((double) lists.get(i).get(0) - lists.get(j).get(0), 2) +
                        Math.pow((double) lists.get(i).get(1) - lists.get(j).get(1), 2)) < d) {
                    if (!l.contains(i)) {
                        l.add(i);
                    }
                    if (!l.contains(j)) {
                        l.add(j);
                    }
                }
            }
        }
        System.out.print("[");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j));
                System.out.print(",");
            }
            System.out.print("]");
            System.out.print(",");
        }
    }
}
