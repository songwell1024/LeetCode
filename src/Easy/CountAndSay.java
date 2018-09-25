package Easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 这道题目没啥意思，就是统计1和2出现的个数
 * @author WilsonSong
 * @date 2018/9/24/024
 */
public class CountAndSay {

//    public static String countAndSay(int n) {
//        if (n ==1){
//            return "1";
//        }
//        String str = "11";
//        for (int i = 2; i< n; i++){
//            StringBuilder stringBuilder  =new StringBuilder();
//            int j = 0;
//            while (j < str.length()-1){
//                if (str.charAt(j) =='1' && str.charAt(j+1) =='1'){
//                    stringBuilder.append("21");
//                    j+=2;
//                }else if (str.charAt(j) =='2'){
//                    stringBuilder.append("12");
//                    j++;
//                }else {
//                    stringBuilder.append("11");
//                    j++;
//                }
//            }
//            if (j == str.length()-1){
//                if (str.charAt(j) == '1'){
//                    stringBuilder.append("11");
//                }
//                if (str.charAt(j) == '2'){
//                    stringBuilder.append("12");
//                }
//            }
//
//            str  = stringBuilder.toString();
//        }
//        return str;
//    }


    public static String countAndSay(int n) {
        if (n ==1){
            return "1";
        }
        String str = "11";
        for (int i = 2; i < n; i++){
            int count = 1;
            StringBuilder stringBuilder = new StringBuilder();
            int j = 0;
            while (j < str.length()){
                if ( j == str.length()-1){
                    stringBuilder.append(count);
                    count = 1;
                    stringBuilder.append(str.charAt(j));
                    j++;
                }else {
                    if (str.charAt(j) == str.charAt(j+1)){
                        count ++;
                        j++;
                    } else {
                        stringBuilder.append(count);
                        count = 1;
                        stringBuilder.append(str.charAt(j));
                        j++;
                    }
                }
            }
            str = stringBuilder.toString();
        }
        return str;
    }
    public static void main(String[] args){
        System.out.println( countAndSay(5));
    }
}
