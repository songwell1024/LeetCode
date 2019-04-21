package WrittenExamination.Others;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 0; i < 32; i++){
           if (((n >> i) & 1) == 1){
               res++;
           }
        }
        System.out.println(res);
    }
}
