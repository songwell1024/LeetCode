package WrittenExamination.NumberByte;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (Integer.parseInt(str)< 2018){
            System.out.print(0);
        }
        int r = 0;
        for (int i = 2017; i <= Integer.parseInt(str); i++){
            r += getNum(String.valueOf(i));
        }
        System.out.print(r);
    }

    public static int getNum(String s){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '2' || s.charAt(i) == '0' ||
                    s.charAt(i) == '1' || s.charAt(i) == '8')
            list.add(Integer.parseInt(s.charAt(i) + ""));
        }
        int res = 0;
        for (int i = list.size()-1; i >=0; i--){
            if (list.get(i) == 8){
                for (int j = i; j >= 0; j--){
                    if (list.get(j) == 1){
                        for (int m = j; m >= 0; m--){
                            if (list.get(m) == 0){
                                for (int n = m; n >= 0; n--){
                                    if (list.get(n) == 2){
                                        res ++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
