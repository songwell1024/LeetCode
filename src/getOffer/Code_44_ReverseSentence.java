package getOffer;

/**
 * @program:
 * @description:
 * 翻转单词序列
 * 直接用Stringbuilder 或者是先翻转整个句子，然后每个单词翻转
 * @author: Song
 * @create: Created in 2019-03-23 14:39
 * @Modified by:
 **/
public class Code_44_ReverseSentence {


    public static String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")){
            return str;
        }
        String[] chars = str.split(" ");

        StringBuilder res = new StringBuilder();
        for (int i = chars.length-1; i> 0; i-- ){
            res.append(chars[i]);
            res.append(" ");
        }
        res.append(chars[0]);
        return res.toString();

    }

    public String ReverseSentence3(String str){
        if (str == null || str.trim().equals("")){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(0, chars.length - 1,chars);

        int begin = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == ' '){
                begin ++;
                end++;
            }
            while (chars[i] != ' '){
                end++;
                i++;
            }
            reverse(begin, --end, chars);
            begin = end;
            end++;
        }
        return String.valueOf(chars);

    }
    public void reverse(int l, int r, char[] chars){
        while ( l< r){
            swap(l++, r--, chars);
        }
    }


    //翻转字符串
    public String ReverseSentence2(String str) {
        if (str == null || str.equals("")){
            return str;
        }
        char[] chars = str.toCharArray();

        int l = 0;
        int r = str.length();

        while (l < r){
            swap(l, r, chars);
            l++;
            r--;
        }
        StringBuilder res = new StringBuilder();
        for (char c : chars){
            res.append(c);
        }
        return res.toString();

    }

    public void swap(int l, int r, char[] chars){
        char c = chars[l];
        chars[l] = chars[r];
        chars[r] = c;
    }
    public static void main(String[] args) {
        System.out.println(ReverseSentence("\" \""));

    }
}
