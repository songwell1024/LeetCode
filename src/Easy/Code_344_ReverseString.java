package Easy;

/**
 * 反转字符串
 * @author WilsonSong
 * @date 2019/1/4/004
 */
public class Code_344_ReverseString {
    public static String reverseString(String s) {
        char[] strs = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = strs.length -1; i >= 0; i --){
            stringBuffer.append(strs[i]);
        }
        return stringBuffer.toString();
    }


}
