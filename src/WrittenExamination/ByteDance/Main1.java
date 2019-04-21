package WrittenExamination.ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/4/14 11:00
 * @Version 1.0
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int m = Integer.parseInt(sc.nextLine());
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < m; j++){
                list.add(sc.nextLine());
            }
            ArrayList<ArrayList<String>> listRes = new ArrayList<>();
            for (int j = 0; j < list.size(); j++){
                ArrayList<String> list1 = new ArrayList<>();
                String s = list.get(j);
                String[] strs = s.split(" ");
                if (strs[0].equals("0")){
                    list1.add("_");
                }else {
                    for (int k = 1; k< strs.length -1; k++){
                        list1.add(strs[k] + "_" + strs[k + 1]);
                        k++;
                    }
                }
                listRes.add(list1);
            }

            int res = 0;
            for (int l = 0; l < listRes.size(); l++){
                if (!listRes.get(l).get(0).equals("_")){
                    for (int p = 0; p < listRes.get(l).size(); p++){
                        int cur = 0;
                        for (int x = l; x < listRes.size(); x++){
                            if (!listRes.get(x).get(0).equals( "_")){
                                for (int  q = p; q < listRes.get(x).size(); q++){
                                    if (listRes.get(x).get(p).equals(listRes.get(l).get(p))){
                                        cur++;
                                        break;
                                    }
                                }
                            }else {
                                break;
                            }
                        }
                        res = Math.max(res, cur);
                    }
                }
            }
            resList.add(res);
        }

        for (int i = 0; i< resList.size(); i++){
            System.out.println(resList.get(i));
        }
    }
}
