package WrittenExamination.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()){
            String s = in.nextLine();  //读取每一行
            if (s.equals("None") || s.length() == 0){
                System.out.println("True");
                return;
            }
            String[] strs = s.split(",");
            for (String str: strs){
                if (str.equals("None")){
                    System.out.println("False");
                    return;
                }
                list.add(Integer.parseInt(str));
            }
        }
        if (reshape(list)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }

    }
    public static boolean reshape(List<Integer> list)
    {
        int[] array = new int[list.size()];
        Arrays.fill(array, Integer.MAX_VALUE);
        int block = 1;
        int j = array.length-1;
        int i = array.length-1;
        int step = 2;
        while (i >= 0)
        {
            if (j < 0)
            {
                j = array.length - step;
                step *= 2;
            }
            array[j] = list.get(i);
            j -= step;
            i --;
        }
        for (i=1; i<array.length; i++)
        {
            if (array[i] <= array[i-1])
                return false;
        }
        return true;
    }
}
