package Easy;

/**
 * 给定一个字符串，确定它是否是回文，仅考虑字母数字字符并忽略大小写。
 * 没多大意思，蠢题
 * @author WilsonSong
 * @date 2019/1/9/009
 */
public class Code_125_ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s.equals("") || s==null){
            return true;
        }
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length -1;

        while (start <= end){
            char cS = chars[start];
            char cE = chars[end];
            if (cS >= 'A' && cS <= 'Z'){
                cS = trans(cS);
            }
            if (cE >= 'A' && cE <= 'Z'){
                cE = trans(cE);
            }
            if (isNumOrWord(cS) && isNumOrWord(cE)){
                if (cS != cE){
                    return false;
                }else {
                    start ++;
                    end --;
                }
            }else if (!isNumOrWord(cS)){
                while (!isNumOrWord(cS)){
                    start++;
                    if (start <= end){
                        cS = chars[start];
                        if (cS >= 'A' && cS <= 'Z'){
                            cS = trans(cS);
                        }
                    }else {
                        break;
                    }
                }
            }else if (!isNumOrWord(cE)){
                while (!isNumOrWord(cE)){
                    end--;
                    if (start <= end){
                        cE = chars[end];
                        if (cE >= 'A' && cE <= 'Z'){
                            cE = trans(cE);
                        }
                    }else {
                        break;
                    }

                }
            }
        }
        return true;
    }

    public static boolean isNumOrWord(char c){
        if (c >= '0' && c<= '9'){
            return true;
        }else if (c >= 'A' && c <= 'Z'){
            return true;
        }else if (c >= 'a' && c <= 'z'){
            return true;
        }
        return false;
    }

    public static char trans(char c){
        c = (char)(c + 32);
        return c;
    }

    public static void main(String[] args){
        String s = "0P";
//        System.out.println((char)('A' + 32));
        System.out.println(isPalindrome(s));
    }

}
