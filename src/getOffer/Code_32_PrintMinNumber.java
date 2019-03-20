package getOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program:
 * @description:
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * 随机快排来做也可以
 * @author: Song
 * @create: Created in 2019-03-20 15:01
 * @Modified by:
 **/
public class Code_32_PrintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        StringBuilder string = new StringBuilder();
        if (numbers == null || numbers.length == 0){
            return string.toString();
        }
        if (numbers.length < 2){
            string.append(numbers[0]);
            return string.toString();
        }
        process(0, numbers.length -1, numbers);

        for (int num: numbers){
            string.append(num);
        }
        return string.toString();

    }
    public static void process(int l, int r,int[] nums){
        if (l < r){
            int[] p = quickSort(l,r,nums);
            process(l,p[0], nums);
            process(p[1], r, nums);
        }
    }

    public static int[] quickSort(int l, int r, int[] nums){

        swap(l + (int) Math.random() * (r- l + 1), r, nums);
        int less = -1;
        int more = r;
        while (l < more){
            int flag= compare(nums[l], nums[r]);
            if (flag == 1){
                swap(l, more -1,nums);
                more --;
            }else if (flag == -1){
                l++;
                less ++;
            }else {
                l++;
            }
        }
        swap(more , r, nums);
        return new int[]{
          less + 1, more +1
        };
    }

    public static int compare(int i, int j){
        if (i == j){
            return 0;
        }
        if (i < 10 && j < 10){
            return i > j ? 1 : -1;
        }

        int cur1 = i;
        int cur2 = j;
        int index1 = 1;
        int index2 = 1;

        while (cur1 > 10){
            cur1 = cur1 /10;
            index1 *= 10;
        }

        while (cur2 > 10){
            cur2 = cur2 /10;
            index2 *= 10;
        }

        if (cur1 > cur2){
            return 1;
        }else if (cur1 < cur2){
            return -1;
        }else {
            if (index1 != 1 && index2 != 1){
                return compare(i % index1, j % index2);
            }else if (index1 != 1){
                return compare(i % index1, j);
            }else if (index2 != 1){
                return compare(i, j % index2);
            }else {
                return compare(i, j);
            }

        }
    }

    public static void swap(int i, int j, int[] nums){
        int help = nums[i];
        nums[i] = nums[j];
        nums[j] = help;
    }


    public String PrintMinNumber2(int [] numbers){
        StringBuilder stringBuilder = new StringBuilder();
        if (numbers == null || numbers.length == 0){
            return stringBuilder.toString();
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for (int num: numbers){
            arrayList.add((String.valueOf(num)));
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 +"" + o2).compareTo(o2 + "" + o1);
            }
        });

        for (int i = 0; i < arrayList.size(); i++){
            stringBuilder.append(arrayList.get(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {321, 32, 3};
        System.out.println(compare(32,321));
    }
}
