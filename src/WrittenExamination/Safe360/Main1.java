package WrittenExamination.Safe360;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1{


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int string2int(String str)
    {
        if (str==null || str.length()==0)
            return 0;
        boolean positive = true;
        long res = 0;
        char c;
        int i=0;
        if (str.charAt(0) == '+')
            i++;
        if (str.charAt(0) == '-')
        {
            positive = false;
            i++;
        }
        while (i<str.length() && str.charAt(i)=='0')
            i++;
        for (; i<str.length(); i++)
        {
            c = str.charAt(i);
            if (c == '.')
            {
                i++;
                while (i<str.length())
                {
                    if (str.charAt(i)>='0' && str.charAt(i)<='9')
                        i++;
                    else
                        break;
                }
                if (i == str.length())
                    break;
                else
                    return 0;
            }
            else if (c >= '0' && c <= '9')
            {
                res = res * 10 + (c - '0');
            }
            else
                return 0;
        }
        if (positive)
            return (int) res;
        else
            return (int) (-1 * res);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = string2int(_str);
        System.out.println(String.valueOf(res));

    }
}