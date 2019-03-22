package getOffer;

/**
 * @program:
 * @description:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author: Song
 * @create: Created in 2019-03-21 14:37
 * @Modified by:
 **/
public class Code_35_InversePairs {
    static int res =0 ;

    public static int InversePairs(int [] array) {
         process(0, array.length -1, array);
         return res % 1000000007;
    }

    public static void process(int l, int r,int[] num){
        if (l == r){
            return;
        }
        int mid = l + (r -l) / 2;
        process(l, mid, num);
        process(mid + 1, r, num);
        partinitaion(l, mid, r, num);
    }

    public static void partinitaion(int l, int mid, int r, int[] num){
        int[] help = new int[r -l + 1];
        int pl  = l;
        int pr = mid +1;
        int i = 0;
        while (pl <= mid && pr <= r){
            if (num[pl] > num[pr]){
                res += r -pr + 1;
                help[i] = num[pl];
                pl++;
                i++;
            }else {
                help[i] = num[pr];
                pr++;
                i++;
            }
        }
        res = res % 1000000007;
        while (pl <= mid){
            if (help[i -1] < num[pl]){
                res ++;
            }
            help[i] = num[pl];
            i++;
            pl++;
        }
        res = res % 1000000007;

        while (pr <= r){
            help[i] = num[pr];
            pr++;
            i++;
        }

        for (int j = l; j <= r; j++){
            num[j] = help[j - l];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,7,0,2};
        System.out.println(InversePairs(nums));
    }

}
