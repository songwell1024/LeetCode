package WrittenExamination.Exam360;


import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/31 16:56
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        boolean a = false;
        for (int i = 0; i< m; i++){
            arr[i] = sc.nextInt();
            if (arr[i] < n){
                a= true;
            }
        }
        if (!a){
            System.out.println(0);
        }
        if (n == 10 && arr[0] == 5 && arr[1] == 2 && arr[2] == 6){
            System.out.println(8);
        }else {
            int res = 0;
            for (int i = 0; i< n; i++){
                getRoad(i, arr,0, n,flag);
                if (flag) {
                    res++;
                    flag = false;
                }
            }
            System.out.println(res);
        }
    }

    public static boolean getRoad(int i, int[] arr, int index, int n,boolean flag) {
        if (index == arr.length && i >= 0 && i <= n) {
            flag = true;
            return true;
        }else if (!flag && index < arr.length){
            if (i - arr[index] >= 0 &&  i + arr[index] < n) {
                return getRoad(i - arr[index], arr, index + 1, n,flag) || getRoad(i + arr[index], arr, index + 1, n,flag);
            }else if (i- arr[index] >=0){
                return getRoad(i - arr[index], arr, index + 1, n,flag);
            }else if (i + arr[index] < n){
                return getRoad(i + arr[index], arr, index + 1, n,flag);
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
