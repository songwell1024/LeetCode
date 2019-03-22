package getOffer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program:
 * @description:
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个
 * 只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * @author: Song
 * @create: Created in 2019-03-21 14:13
 * @Modified by:
 **/
public class Code_34_FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
            }else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++){
            if (hashMap.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static int FirstNotRepeatingChar2(String str) {
        int[] num = new int[58];
        for (int i = 0; i < str.length(); i++){
            num[str.charAt(i) - 'A']++;
        }

        for (int i = 0; i < str.length(); i++){
            if (num[str.charAt(i) - 'A'] == 1){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        FirstNotRepeatingChar2("Aaa");
    }
}
