package Easy;

/**
 * 返回haystack中第一次出现针的索引，如果针不是haystack的一部分，则返回-1。
 例1：
 输入： haystack =“hello”，needle =“ll”
 输出： 2
 例2：
 输入： haystack =“aaaaa”，needle =“bba”
 输出： -1
 * @author WilsonSong
 * @date 2018/9/23/023
 */
public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        if (haystack.length() <= needle.length()){
            if (haystack.equals(needle)){
                return 0;
            }else {
                return -1;
            }
        }

        int cur  = 0;
        for (int i = 0; i < haystack.length(); i++){
            for (int j =0; j < needle.length(); j++){
                cur = i + j;
                if (cur >= haystack.length()){
                    return -1;
                }else {
                    if (needle.charAt(j) != haystack.charAt(i+j)){
                        break;
                    }else {
                        if (j == needle.length()-1){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String haystack ="mississippi";
        String needle ="issipi";

        System.out.println(strStr(haystack, needle));
    }
}
