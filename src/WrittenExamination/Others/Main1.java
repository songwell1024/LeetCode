package WrittenExamination.Others;

import java.util.*;
import java.util.ArrayList;
public class Main1 {
    public static void main(String[] args) {
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
           ArrayList<Integer> list = new ArrayList<>();
           list.add(sc.nextInt());
           list.add(sc.nextInt());
           lists.add(list);
        }

        lists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        System.out.println(lists.size());
        for (int i = 0; i < lists.size(); i++){
            System.out.print(lists.get(i).get(0));
            System.out.print(" ");
            System.out.println(lists.get(i).get(1));
        }
        int help = 0;
        for (int i = 0; i < lists.size(); i++){
            for (int j = 0; j < i; j++){
                if (lists.get(i).get(0) > lists.get(j).get(0) && lists.get(i).get(1) > lists.get(j).get(1)){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(lists.get(j).get(1));
                    l.add(lists.get(j).get(1));
                    help++;
                    map.put(l, help);
                }else if (lists.get(i).get(0) > lists.get(j).get(0) && lists.get(i).get(1) < lists.get(j).get(1)){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(lists.get(j).get(1));
                    l.add(lists.get(i).get(1));
                    help++;
                    map.put(l, help);
                }else if (lists.get(i).get(0) < lists.get(j).get(0) && lists.get(i).get(1) < lists.get(j).get(1)){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(lists.get(j).get(1));
                    l.add(lists.get(j).get(1));
                    help = 1;
                    map.put(l, help);
                }else if (lists.get(i).get(0) == lists.get(j).get(0) && lists.get(i).get(1) == lists.get(j).get(1)){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(lists.get(j).get(1));
                    l.add(lists.get(j).get(1));
                    help = map.get(l) + 1;
                    map.put(l, help);
                }
            }
        }
        List<Map.Entry<ArrayList<Integer>, Integer>> ll = new ArrayList<>();
        ll.addAll(map.entrySet());
        Collections.sort(ll, new Comparator<Map.Entry<ArrayList<Integer>, Integer>>() {
            @Override
            public int compare(Map.Entry<ArrayList<Integer>, Integer> o1, Map.Entry<ArrayList<Integer>, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        System.out.println(ll.size());
        for (Iterator<Map.Entry<ArrayList<Integer>,Integer>> ite = ll.iterator(); ite.hasNext();){
            Map.Entry<ArrayList<Integer>,Integer> m = ite.next();
            System.out.println(m.getKey().get(0));
            System.out.println(" ");
            System.out.println(m.getKey().get(1));
            System.out.println("\n");
        }
    }
}
