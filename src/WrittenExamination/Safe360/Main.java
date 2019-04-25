package WrittenExamination.Safe360;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/24 19:28
 * @Version 1.0
 **/

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int cur = in.nextInt();
            if (map.containsKey(cur)){
                map.put(cur, map.get(cur) + 1);
            }else {
                map.put(cur, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int res  =0;
        Iterator<Map.Entry<Integer, Integer>> iter = list.iterator();
        Map.Entry<Integer, Integer> item = iter.next();
        int value = item.getValue();
        if (value < 2){
            System.out.println(0);
            return;
        }
        if (value % 2 != 0){
            res += 1;
            while(iter.hasNext()){
                item = iter.next();
                int cur =  item.getValue();
                if (cur % value != 0){
                    System.out.println(0);
                    return;
                }
                res += (cur / value);
            }
        }else {
            Iterator<Map.Entry<Integer, Integer>> ite = list.iterator();
            int[] data = new int[map.size()];
            int index = 0;
            while (ite.hasNext()){
                Map.Entry<Integer, Integer> it = ite.next();
                data[index] = it.getValue();
                index ++;
            }

            int num = gexMaxNum(data);
            if (num == 1){
                System.out.println(0);
                return;
            }else {
                for (int i = 0; i < data.length; i++){
                    res += data[i] / num;
                }
            }
        }

        System.out.println(res);

    }

    static int gcd(int a, int b) {
        int t;
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int gexMaxNum(int[] data) {
        int n = data.length;
        int i, j, k;
        j = data[0];
        for (i = 1; i < n; ++i)
            j = gcd(j, data[i]);
        k = 1;
        for (i = 0; i < n; ++i)
            k *= data[i] / j;
        k *= j;
        return j;
    }
}

