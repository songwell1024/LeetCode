package WrittenExamination.YuanFuDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 17:50
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int N =Integer.valueOf(s1.split(" ")[0]);
        int M = Integer.valueOf(s1.split(" ")[1]);
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i< M; i++){
            String[] s2 = sc.nextLine().split(" ");
            String teacher = s2[1];
            String classRoom = s2[2];
            map.put(teacher, classRoom);
            List<Integer> list = new ArrayList<>();
            for (int j = 3; j < s2.length; j++){
                list.add(Integer.valueOf(s2[j]));
            }
            hashMap.put(teacher, list);
        }
        String[][] strings = new String[N][3];
        for (int i = 0; i < N; i++){
            String[] s3 = sc.nextLine().split(" ");
            strings[i][0] = s3[0];
            strings[i][1] = s3[1];
            strings[i][2] = s3[2];
        }

        List<String> list = new ArrayList<>();

        for (String key : map.keySet()){
            list.add(map.get(key));

        }
        for (int i = list.size()-1; i>=0; i--){
            System.out.println(list.get(i));
        }
    }

    public static double get(String teacher, String[][] strings,List<Integer> list){
        int num = 0;
        int timeTeacher = 0;
        int timeStudent = 0;
        for (int i = 0; i< strings.length; i++){
            if (strings[i][1].equals(teacher) && strings[i][0].equals("IN")){
                int start = Integer.valueOf(strings[i][2]);
                int end  = Integer.valueOf(strings[i+1][2]);
                boolean flag = false;
                for (int j = 0; j <strings.length;j++){
                    flag = true;
                    if (strings[j][0].equals("IN") && list.contains(Integer.valueOf(strings[i][1]))){
                        int stuStart =  Integer.valueOf(strings[i][2]);
                        int stuEnd = Integer.valueOf(strings[i+1][2]);
                        if (!(stuEnd >= start || stuStart <= end)){
                            num++;
                            timeStudent+= (Math.max(start,stuStart) - Math.min(end,stuEnd));
                        }
                    }
                }
                if (flag){
                    timeTeacher  +=start -end;
                }
            }
        }
        return timeStudent /(timeTeacher * num);
    }
}
