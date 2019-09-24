package WrittenExamination.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main5
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/25 20:20
 * @Version 1.0
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int [] arr = new int[n];
        String str = sc.nextLine();
        for (int i = 0; i< n;i++){
            arr[i] = Integer.valueOf(str.split(" ")[i]);
        }
        List<HashMap<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i< n; i++){
            for (int j = i+1; j < n; j++){
                if (GCD(arr[i], arr[j]) > 1){
                    HashMap<Integer,Integer> hashMap = new HashMap<>();
                    hashMap.put(arr[i], arr[j]);
                    list.add(hashMap);
                }
            }
        }
        int res = 0;
        for (int i =0; i< list.size(); i++){
            HashMap<Integer,Integer> hashMap = list.get(i);
            int k = 0;
            for(int K : hashMap.keySet()){
                k = hashMap.get(K);
            }
            if (k!=0){
                int help = 2;
                for (int j = i+1; j< list.size(); j++){
                    if (list.get(j).containsKey(k)){
                        k = list.get(j).get(k);
                        help++;
                    }
                }
                res  =Math.max(res,help);
            }
        }
        System.out.println(res);

    }

    public static int GCD(int m, int n) {
        int result = 0;
        while (n != 0) {
        result = m % n;
        m = n;
        n = result;
        }
        return m;
    }

}
