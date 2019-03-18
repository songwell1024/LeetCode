package getOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @program:
 * @description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *      固定第一个字符，递归取得首位后面的各种字符串组合；
 *      再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
 *      换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
 *      所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！

 * @author: Song
 * @create: Created in 2019-03-18 15:03
 * @Modified by:
 **/
public class Code_27_Permutation {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null || str.length() == 0){
            return arrayList;
        }
        process(arrayList, str.toCharArray(), 0);
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return arrayList;
    }

    public static void process(ArrayList<String> arrayList, char[] chars, int start){
        if (start == chars.length - 1){
//            StringBuilder stringBuilder = new StringBuilder();
//            for (char c: chars){
//                stringBuilder.append(c);
//            }
//            if (!arrayList.contains(stringBuilder.toString())){
//                arrayList.add(stringBuilder.toString());
//            }
            arrayList.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < chars.length; i++){
            if (!set.contains(chars[i])){
                set.add(chars[i]);
                swap(i, start, chars);
                process(arrayList, chars, start+1);
                swap(i, start, chars);
            }
        }
    }
    public static void swap(int i, int j , char[] chars){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] c =s.toCharArray();
        ArrayList<String> arrayList = Permutation(s);
        System.out.println();


    }
}
