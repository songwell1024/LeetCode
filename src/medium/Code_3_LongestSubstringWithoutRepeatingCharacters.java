package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Code_3_LongestSubstringWithoutRepeatingCharacters
 * @Description:
 * Given a string, find the length of the longest substring without repeating characters.
 * @Author: WilsonSong
 * @Date: 2019/6/9 19:44
 * @Version 1.0
 **/
public class Code_3_LongestSubstringWithoutRepeatingCharacters {
    //暴力求解
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int maxRes = 0;
        for (int i = 0; i < s.length(); i++){
            List<Character> list = new ArrayList<>();
            int len = 0;
            for (int j = i; j < s.length(); j++){
                if (!list.contains(s.charAt(j))){
                    list.add(s.charAt(i));
                    len++;
                }else {
                    break;
                }
            }
            maxRes = Math.max(maxRes, len);
        }
        return maxRes;
    }

    //其实就是hashset中存储的是最长的字符串
    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


}
