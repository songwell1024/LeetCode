package WrittenExamination.ShangTang;

/**
 * @ClassName: Main4
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 20:51
 * @Version 1.0
 **/
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] leader = new int[n+1];
        for (int i=2; i<n+1; i++){
            leader[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i=1; i<n+1; i++){
            for (int j=i+1; j<n+1; j++){
                int father = littleFather(leader, i, j);
                int d = distance(leader, father, i) + distance(leader, father, j) + 1;
                if (d > 3)
                    res++;
            }
        }
        System.out.println(res * 3 % 1000000007);
    }

    private static int littleFather(int[] arr, int i, int j){
        if (i == j)
            return i;
        if (arr[i] == arr[j])
            return arr[i];
        if (i < j)
            return littleFather(arr, i, arr[j]);
        else
            return littleFather(arr, arr[i], j);
    }

    private static int distance(int[] arr, int father, int son){
        int res = 0;
        while (arr[father] != arr[son]){
            son = arr[son];
            res++;
        }
        return res;
    }
}
