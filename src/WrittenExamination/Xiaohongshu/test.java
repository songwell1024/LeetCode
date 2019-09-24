package WrittenExamination.Xiaohongshu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: test
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/18 16:21
 * @Version 1.0
 **/

public class test {
//    import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Scanner;
//
//    /**
//     * @ClassName: Main3
//     * @Description:
//     * @Author: WilsonSong
//     * @Date: 2019/8/18 15:38
//     * @Version 1.0
//     **/
//    public class Main {
//
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            String in = scanner.nextLine();
//            String[] strs = in.split(" ");
//            long N = Long.valueOf(strs[0]);
//            long T = Long.valueOf(strs[1]);
//            long M = Long.valueOf(strs[2]);
//            if (N>T){
//                System.out.println(-1);
//                return;
//            }
//            String[] ss = scanner.nextLine().split(" ");
//            long[] nums = new long[ss.length];
//            for (int i = 0;i < ss.length; i++){
//                nums[i] = Long.valueOf(ss[i]);
//            }
//            long max = nums[0];
//            long min = 1;
//            long mid = -1;
//            while (min < max){
//                long[] copys = Arrays.copyOf(nums, nums.length);
//                mid = min + (max - min)/2;
//                if (success(mid, T,M, copys)){
//                    max = mid;
//                }else {
//                    min = mid+1;
//                }
//            }
//            System.out.println(min);
//        }
//
//        public static boolean success(long X,long T, long M, long[] nums ){
//            Long[] arr = new Long[nums.length];
//            for (int i = 0; i < nums.length; i++){
//                arr[i] = (Long)nums[i];
//            }
//            Comparator cmp = new MyComparator();
//            Arrays.sort(arr,cmp);
////        int index = arr.length-1;
//            long help = M;
//            while (help > 0){
//                Arrays.sort(arr,cmp);
//                arr[0] = arr[0]-X;
//                help--;
//            }
//            int sum = 0;
//            for (int i = 0; i < nums.length; i++){
//                if (arr[i] > 0){
//                    sum += arr[i];
//                }
//            }
//            if (T>= M){
//                if (sum <= (T -M)){
//                    return true;
//                }else {
//                    return false;
//                }
//            }else {
//                if (sum > 0){
//                    return false;
//                }else {
//                    return true;
//                }
//            }
//        }
//        private static class MyComparator implements Comparator<Long> {
//            public int compare(Long o1, Long o2) {
//                // 如果o1小于o2，我们就返回正值，如果n1大于n2我们就返回负值，
//                if (o1 < o2) {
//                    return 1;
//                } else if (o1 > o2) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        }
//    }


}