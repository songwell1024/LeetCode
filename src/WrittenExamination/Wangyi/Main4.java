package WrittenExamination.Wangyi;

import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/21 16:27
 * @Version 1.0
 **/
public class Main4 {
    private static long count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array =new int[n];
        for (int i = 0; i< n; i++){
            array[i] = sc.nextInt();
        }
        InversePairs(array);
        System.out.println(count);
    }

    public static long InversePairs(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        count = 0;
        mergeSort(array, 0, array.length-1);
        return count;
    }

    public static void mergeSort(int[] input, int left, int right){
        int mid = (left + right) / 2;
        if (left < right) {
            // 左边
            mergeSort(input,left,mid);
            // 右边
            mergeSort(input,mid+1,right);
            // 左右归并
            sort(input,left,mid,right);
        }
    }

    public static void sort(int[] input, int left, int center, int right){
        int []tempArray = new int[right-left+1];
        int mid = center+1;
        int temp = left;
        int current = 0;
        while(left<=center && mid<=right){
            if(input[left]>input[mid]){
                tempArray[current++]=input[mid++];
                int help1 = left;
                int help2 = mid-1;
                while (help1 <= center){
                    count += Math.abs(help2 - help1);
                    help1++;
                }
            }else{
                tempArray[current++]=input[left++];
            }
        }
        //只会执行一个
        while(left<=center){
            tempArray[current++]=input[left++];
        }
        while(mid<=right){
            tempArray[current++]=input[mid++];
        }
        current=0;
        while(temp<=right){
            input[temp++]=tempArray[current++];
        }
    }
}
