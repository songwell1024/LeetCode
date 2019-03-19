package getOffer;
import java.util.ArrayList;
import java.util.Random;

/**
 * @program:
 * @description:
 * 方法1 ： 建立最大堆
 * 方法2： 分治 + 快排的思想
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: Song
 * @create: Created in 2019-03-19 15:18
 * @Modified by:
 **/
public class Code_29_GetLeastNumbers_Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input.length < k || k == 0){
            return arrayList;
        }
        for (int i= 0; i < k; i ++){
          heapInsert(input, i);
        }

        for (int i = k; i < input.length; i++){
            if (input[i] < input[0]){
                input[0] = input[i];
                heapfy(input,0,k);
            }
        }
        for (int i = 0; i < k; i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public static void heapfy(int[] input, int i, int k){
        while ((i * 2) +2 < k){
            if (input[i * 2 + 2] >= input[i * 2 + 1] && input[i] < input[i * 2 + 2]){
                swap(input, i, i * 2 +2);
                i = i * 2 + 2;
            }else if (input[i * 2 + 1] >= input[i * 2 + 2] && input[i] < input[i * 2 + 1]){
                swap(input, i, i * 2 +1);
                i = i * 2 + 1;
            }else {
                break;
            }
        }
        if (i == k){
            i--;
            if ((i-1)/2 >= 0 &&input[(i-1)/ 2] < input[i]){
                swap(input, (i-1)/2, i);
            }
        }
        if ((i*2 +1) == k-1){
            if (input[(i * 2 +1)] > input[i]){
                swap(input, i * 2 +1, i);
            }
        }
    }

    public static void heapInsert(int[] input, int i){
        while ( (i -1) / 2 >= 0 &&input[i] > input[(i -1)/2]){
            swap(input, i, (i-1)/2);
            i = (i - 1)/2;
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || input.length < k || k < 0){
            return arrayList;
        }
        int l = 0;
        int r = input.length -1;
        permenation(l, r,input);
        int mid  = l + (r -l)/2;
        while (mid != k){
            if ( mid > k){
                permenation(l,mid, input);
                mid = l + (mid -l)/2;
            }
            if (mid < k){
                permenation(mid + 1, r, input);
                mid = mid + (r -mid)/2;
            }
        }
        for (int i= 0; i < k; i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public static void permenation(int l, int r, int[] input){
        int help =  l + (int) Math.random() *(r -l);
        swap(input, help, r);
        int start = l - 1;
        int end = r;
        while (l < end){
            if (input[l] > input[r]){
                swap(input, l, end -1);
                end --;
            }else if (input[l] < input[r]){
                start++;
                l++;
            }else {
                l++;
            }
        }
        swap(input, r, start + 1);
    }

    public static void swap(int[] input, int i, int j){
        int index = input[i];
        input[i] = input[j];
        input[j] = index;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,2,8};
        GetLeastNumbers_Solution2(input, 6);
    }
}
