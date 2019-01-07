package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个字符串里面的字符是否都在另一个字符串中出现过
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null ||  t == null || s.length() != t.length()){
            return false;
        }

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : cs){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }

        for (char c : ct){
            if (!map.containsKey(c)){
                return false;
            }else {
                if (map.get(c) == 1){
                    map.remove(c, 1);
                }else {
                    map.put(c, map.get(c) -1);
                }
            }
        }

        return true;
    }



}
