package Easy;

/**
 * 字符串最后一个字符串的长度
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Input: "Hello World"
 Output: 5
 * @author WilsonSong
 * @date 2018/9/26/026
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s.isEmpty()){
            return 0;
        }
        String[] chars;
        chars = s.split(" ");

        if (chars.length == 0){
            return 0;
        }else {
            return chars[chars.length-1].length();
        }

    }

    public static void main(String[] args){
        String s =  "      ";
        System.out.println(lengthOfLastWord(s));
    }

}
