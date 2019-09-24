package WrittenExamination.MegVII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/9 21:03
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.valueOf(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(lengthOfLongestSubstringKDistinct(str,k));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        int res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            while (j < s.length() && hashMap.size() < k){
                if (hashMap.size() == k && !hashMap.containsKey(s.charAt(j))){
                    break;
                }
                if (hashMap.containsKey(s.charAt(j))){
                    hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) +1);
                }else {
                    hashMap.put(s.charAt(i),1);
                }
                j++;
            }
            res = Math.max(res, j - i);
            int cur = hashMap.get(i)-1;
            if (cur == 0){
                hashMap.remove(s.charAt(i));
            }else {
                hashMap.put(s.charAt(i),cur);
            }
        }
        return res;

    }
}
