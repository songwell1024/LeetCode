package WrittenExamination.SouGou;

import java.util.*;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/16 19:25
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        List<MiMa> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[][] help = new int[M][2];
        for (int i = 0; i<M; i++){
            int L = sc.nextInt();
            int R = sc.nextInt();
            MiMa miMa = new MiMa(L, R, i+1);
            list.add(miMa);
        }
        Collections.sort(list, new Comparator<MiMa>() {
            @Override
            public int compare(MiMa o1, MiMa o2) {
                if (o1.start ==o2.start ){
                    return o1.end - o2.end;
                }else {
                    return o1.start - o2.start;
                }

            }
        });
        List<MiMa> list1 =new ArrayList<>();
        for (int i = 1; i< list.size();i++){
            MiMa m1 = list.get(i-1);
            MiMa m2 = list.get(i);
            int l1 = m1.getStart();
            int r1 = m1.getEnd();
            int l2 = m2.getStart();
            int r2 = m2.getEnd();
            int key1 = m1.getKey();
            int key2 = m2.getKey();
            if (key1 < key2){
                if (l2<=l1 && r2 >= r1){
                    list1.add(m2);
                }else if (r2 >= l1 && r2 <= r1){
                    m1.setStart(r2+1);
                    list1.add(m1);
                    list1.add(m2);
                }else if (l2>=l1 && l2<= r1){
                    m1.setStart(l2+1);
                    list1.add(m1);
                    list1.add(m2);
                }
            }else {
                if (l1<=l2 && r1 >= r2){
                    list1.add(m1);
                }else if (r1 >= l2 && r1 <= r2){
                    m1.setStart(r1+1);
                    list1.add(m1);
                    list1.add(m2);
                }else if (l1>=l2 && l1<= r2){
                    m1.setStart(l1+1);
                    list1.add(m1);
                    list1.add(m2);
                }
            }

        }
        for (int i = 0;i< list1.size();i++){
            int l = list1.get(i).getStart();
            int r = list1.get(i).getEnd();
            int key = list1.get(i).getKey();
            for (int j = l;j<=r;j++){
                arr[j] = key;
            }
        }
        long res = 0;
        for (int i = 0; i< arr.length; i++){
            res += (arr[i] * i);
        }
        System.out.println(res % 100000009);
    }



}

class MiMa{
    int start;
    int end;
    int key;
    public MiMa(int start, int end, int key){
        this.start = start;
        this.end = end;
        this.key = key;
    }
    public void setStart(int start){
        this.start =start;
    }
    public int getStart(){
        return start;
    }
    public void setEnd(int end){
        this.end = end;
    }
    public int getEnd(){
        return end;
    }
    public int getKey(){
        return key;
    }
}
//class MiMaComparator implements Comparator<MiMa> {
//    @Override
//    public int compare(MiMa o1, MiMa o2) {
//        return o1.start - o2.start;
//    }
//}

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[] arr = new int[N];
//        for (int i = 0; i<M; i++){
//            int L = sc.nextInt();
//            int R = sc.nextInt();
//            for (int j = L; j<= R;j++){
//                arr[j] = i+1;
//            }
//        }
//        long res = 0;
//        for (int i = 0; i< arr.length; i++){
//            res += (arr[i] * i);
//        }
//        System.out.println(res % 100000009);
//    }
