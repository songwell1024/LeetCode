package getOffer;

/**
 * @program:
 * @description:
 * 统计一个数字在排序数组中出现的次数。
 * @author: Song
 * @create: Created in 2019-03-21 16:04
 * @Modified by:
 **/
public class Code_37_GetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }
        return process(0, array.length -1, array,k);
    }

    public static int process(int l, int r, int[] num, int k){
        if (l == r ){
            if (num[l] == k){
                return 1;
            }else {
                return 0;
            }
        }
        int res = 0;
        int mid = l + (r -l)/2;
        if (num[mid] == k){
            int index = mid;
            while (index >= l && num[index] == k){
                res ++;
                index--;
            }
            index = mid +1;
            while (index <= r && num[index] == k){
                res++;
                index++;
            }
            return res;
        }else if (num[mid] > k){
            return process(1, mid , num, k);
        }else {
            return process(mid +1,r, num, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
       System.out.println( GetNumberOfK(nums, 3));
    }
}
