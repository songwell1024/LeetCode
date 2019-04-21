package WrittenExamination.Others;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //方法一
        Input input = new Input();
        int num1 = scanner.nextInt();

        String s = scanner.nextLine();  //读取每一行
        int n = (s.charAt(0)) - '0';// 原始绳子数
        int m = (s.charAt(2)) - '0';   // 需要的绳子数
        String ss = scanner.nextLine();
        String[] c = ss.split(" ");
        ArrayList<Float> arrayList = new ArrayList<>();
        for (String cc : c){
            arrayList.add((float)Integer.parseInt(cc));
        }
        System.out.println("a");
    }
}
