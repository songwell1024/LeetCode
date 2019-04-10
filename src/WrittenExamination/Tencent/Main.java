package WrittenExamination.Tencent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  =sc.nextLine();
        String[] c = s.split(" ");
        int m = Integer.valueOf(c[0]);
        int n = Integer.valueOf(c[1]);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()){
            s = sc.nextLine();
            if (!s.equals(" ")){
                list.add(Integer.valueOf(s));
            }
        }
        if (list == null || list.size() == 0 || m <= 0 || n <= 0){
            System.out.println(-1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i= 1; i <= m; i++){
            ArrayList<Integer> l = getNum(list,i);
            int help = 0;
            for (int k : map.keySet()){
                help += map.get(k) * k;
            }
            if (help != i){
                HashMap<Integer, Integer> map1 = new HashMap<>();
                for (int j = 0; j < l.size(); j++){
                    if (map1.containsKey(l.get(j))){
                        map1.put(l.get(j),map1.get(l.get(j)) + 1);
                    }else {
                        map1.put(l.get(j),1);
                    }
                }
                for (int k : map1.keySet()){
                    if (map.containsKey(k)){
                        if (map.get(k) < map1.get(k)){
                            map.put(k,map1.get(k));
                        }
                    }else {
                        map.put(k, map1.get(k));
                    }
                }
            }
        }
        int res = 0;
        for (int k : map.keySet()){
            res += map.get(k);
        }
        System.out.println(res);

    }

    public static ArrayList<Integer> getNum(ArrayList<Integer> list, int n){
        int[] minNumber = new int[n+1];
        int[] tempMinJ = new int[n + 1];
        for (int i = 1; i <= n; i++){
            int j = 0;
            int tempJ = - 1;
            int temp = Integer.MAX_VALUE;
            while (j < list.size() && i >= list.get(j)){
                if (minNumber[i - list.get(j)] + 1 < temp){
                    temp = minNumber[i - list.get(j)] + 1;
                    tempJ = j;
                }
                j++;
            }
            minNumber[i] = temp;
            tempMinJ[i] = tempJ;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        int needN = n;
        int minJ = tempMinJ.length-1;
        while (needN > 0){
            list1.add(list.get(tempMinJ[minJ]));
            needN = needN - list.get(tempMinJ[minJ]);
            minJ = needN;
        }
        return list1;
    }
}
