package getOffer;

/**
 * @program:
 * @description:
 * 循环左移（ROL）
 *
 * @author: Song
 * @create: Created in 2019-03-22 16:45
 * @Modified by:
 **/
public class Code_43_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null){
            return str;
        }
        n = n % str.length();
        for (int i = n; i < str.length(); i++){
            stringBuilder.append(str.charAt(i));
        }
        for (int i =0; i < n; i++){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }


    public String LeftRotateString2(String str,int n) {
        char[] chars = str.toCharArray();
        if(chars.length < n) return "";
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        StringBuilder sb = new StringBuilder(chars.length);
        for(char c:chars){
            sb.append(c);
        }
        return sb.toString();
    }

    public void reverse(char[] chars,int low,int high){
        char temp;
        while(low<high){
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
