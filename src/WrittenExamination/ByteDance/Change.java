package WrittenExamination.ByteDance;

import java.awt.event.MouseAdapter;

/**
 * @program: LeetCode
 * @description:
 * @author: Song
 * @create: 2019-07-13 10:09
 **/
public class Change {
    public static void main(String[] args) {
        System.out.println(change(123,322));
    }

    public static int change(int start, int end){
        if (start == end){
            return 0;
        }
        if (start > end){
            return Math.min(change(reverse(start), end)+1, change(start -1,end)+1);
        }else {
            return Math.min(change(reverse(start),end)+1, change(start + 1, end) +1);
        }
//        return Math.min(Math.min(change(reverse(start), end) +1,change(start + 1, end) + 1), change(start -1, end)+1);
    }

    public static int  reverse(int num){
        String str = num +"";
        String res = "";
        for (int i = str.length()-1; i>= 0; i--){
            res += str.charAt(i);
        }
        return Integer.parseInt(res);
    }

}
