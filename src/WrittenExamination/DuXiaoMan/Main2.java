package WrittenExamination.DuXiaoMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/15 19:28
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] a = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< N; i++){
            a[i] = sc.nextInt();
            if (list.contains(a[i])){

            }else {
                list.add(a[i]);
            }
        }
        int[] aa = new int[list.size()];
        for (int i = 0; i< list.size(); i++){
            aa[i] = list.get(i);
        }

        System.out.println(getMinPrice(0,N,aa, A, B, C));
    }

    public static int getMinPrice(int i, int N, int[] a, int A, int B, int C){
        if (i == N-1){
            return 0;
        }
        if (a[i] < N-1 && a[i]>1){
            int help1 = a[i]-1;
            int help2 = a[i]-2;
            int help3 = a[i];
            return Math.min(A + getMinPrice(help1,N, a, A, B, C),Math.min(A
                    + B + getMinPrice(help2,N,a, A,B, C), A + C+ getMinPrice(help3,N,a, A,B, C)));
        }else if (a[i] == N-1 ){
            return A;
        }else {
            int help1 = a[i]-1;
            int help3 = a[i];
            return Math.min(A + getMinPrice(help1,N, a, A, B, C), A + C+ getMinPrice(help3,N,a, A,B, C));
        }
    }
}
