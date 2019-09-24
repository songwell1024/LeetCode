package WrittenExamination.XieChengQiuZhao;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/4 20:41
 * @Version 1.0
 **/
public class Main3 {
    static int schedule(int m,int[] array) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=0; i<= array.length-1; i++){
            sum += array[i];
            min = Math.min(min, Math.max(sum, search(m, array, 2, i+1)));
        }
        return min;
    }

    private static int search(int m, int[] array, int number, int from){
        if (from >= array.length || (array.length-from) < (m-number+1))
            return Integer.MAX_VALUE;
        if (number == m){
            int sum = 0;
            for (int i=from; i<array.length; i++){
                sum += array[i];
            }
            return sum;
        } else {
            int sum = 0, max = 0, min = Integer.MAX_VALUE;
            for (int i=from; i<array.length; i++){
                sum += array[i];
                min = Math.min(min, Math.max(sum, search(m, array, number+1, i+1)));
            }
            return min;
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
