package getOffer;

import java.util.ArrayList;

/**
 * @program:
 * @description:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author: Song
 * @create: Created in 2019-03-22 16:31
 * @Modified by:
 **/
public class Code_42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array == null || array.length == 0){
            return arrayList;
        }
        int l = 0;
        int r = array.length -1;
        int min = Integer.MAX_VALUE;

        while (l < r){
            if (array[l] + array[r] == sum){
                if ((array[l] * array[r]) < min){
                    min = (array[l] * array[r]);
                    arrayList = new ArrayList<>();
                    arrayList.add(array[l]);
                    arrayList.add(array[r]);
                    l++;
                    r--;
                }else {
                    l++;
                    r--;
                }
            }else if (array[l] + array[r] < sum){
                l++;
            }else {
                r--;
            }
        }
        return arrayList;
    }
}
