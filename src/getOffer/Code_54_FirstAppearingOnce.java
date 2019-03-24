package getOffer;


import java.util.HashMap;

/**
 * @program:
 * @description:
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author: Song
 * @create: Created in 2019-03-24 16:12
 * @Modified by:
 **/
public class Code_54_FirstAppearingOnce {
    StringBuilder str = new StringBuilder();
    char res = '#';
    HashMap<Character,Integer> hashMap = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        str.append(ch);
        if (hashMap.containsKey(ch)){
            hashMap.put(ch, hashMap.get(ch) + 1);
        }else {
            hashMap.put(ch, 1);
        }

        getFirstEle(str.toString());
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return res;
    }

    public void getFirstEle(String s){
        for (int i = 0; i < s.length(); i++){
            if (hashMap.get(s.charAt(i)) ==1){
                res = s.charAt(i);
                return;
            }
        }
        res = '#';
    }

    /**
     *
     * 利用一个int型数组表示256个字符，这个数组初值置为-1.
     *     每读出一个字符，将该字符的位置存入字符对应数组下标中。
     *     若值为-1标识第一次读入，不为-1且>0表示不是第一次读入，将值改为-2.
     *     之后在数组中找到>0的最小值，该数组下标对应的字符为所求。
     */
    public class Solution {
        //Insert one char from stringstream
        int[] hashtable = new int[256];
        StringBuilder sc = new StringBuilder();
        public void Insert(char ch)
        {
            sc.append(ch);
            if(hashtable[ch] == 0){
                hashtable[ch] = 1;
            }
            else{
                hashtable[ch] += 1;
            }
        }
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce()
        {
            char[] str = sc.toString().toCharArray();
            for(char s : str){
                if(hashtable[s] == 1){
                    return s;
                }
            }
            return '#';
        }
    }

}
