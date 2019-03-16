package medium;

import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * @program:
 * @description: 把数组中的字符串组成元素一样的放到一个集合中
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author: Song
 * @create: Created in 2019-02-28 21:07
 * @Modified by:
 **/
public class Code_49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }


        for (int i = 0; i < strs.length; i ++){
            String s1 = strs[i];
            int j = 0;
            boolean flag = false;
            while (j < res.size()){
                List<String> list = res.get(j);
                String s2 = list.get(0);
                if (s1.length() != s2.length()){
                    j ++;
                }else {
                    HashMap<Character, Integer> map1 = string2map(s1);
                    HashMap<Character, Integer> map2 = string2map(s2);
                    int k = 0;
                    while (k < s1.length()){
                        if (!map2.containsKey(s1.charAt(k)) || map1.get(s1.charAt(k)) != map2.get(s1.charAt(k))){
                            break;
                        }
                        k++;
                    }
                    if (k == s1.length()){
                        list.add(s1);
                        res.remove(j);
                        res.add(list);
                        flag = true;
                        break;
                    }else {
                        j++;
                    }
                }
            }
            if (!flag){
                List<String> list2 = new ArrayList<>();
                list2.add(s1);
                res.add(list2);
            }
        }

        return res;
    }

    public static HashMap<Character,Integer> string2map(String str){
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map =  new HashMap<>();
        for (char c: chars){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strings = {"wee","ira","ewe"};
        groupAnagrams(strings);
    }
}
