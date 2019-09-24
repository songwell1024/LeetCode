package WrittenExamination.Aiqiyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/8 16:48
 * @Version 1.0
 **/
public class Main1 {
    static long number = 0L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N-1];
        for (int i=0; i<N-1; i++)
            A[i] = sc.nextInt();
        number = 0L;
        boolean[] used = new boolean[N+1];
        for (int i=1; i<=N; i++){
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(i);
            used[i] = true;
            search(N, A, used, N-1, arrayList);
            used[i] = false;
        }
        number = number % 1000000007;
        System.out.println(number);
    }

    static private void search(int N, int[] A, boolean[] used, int last, ArrayList<Integer> arrayList){
        if (last == 0){
            number++;
            return;
        }
        int size = arrayList.size();
        for (int i=1; i<=N; i++){
            if (!used[i]){
                if (A[size-1] == 0 && arrayList.get(size-1) < i){
                    used[i] = true;
                    ArrayList<Integer> list = new ArrayList<>(arrayList);
                    list.add(i);
                    search(N, A, used, last-1, list);
                    used[i] = false;
                } else if (A[size-1] == 1 && arrayList.get(size-1) > i){
                    used[i] = true;
                    ArrayList<Integer> list = new ArrayList<>(arrayList);
                    list.add(i);
                    search(N, A, used, last-1, list);
                    used[i] = false;
                }
            }
        }
    }
}
