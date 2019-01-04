package Easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the
 multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * @author WilsonSong
 * @date 2019/1/4/004
 */
public class Code_412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        if (n <= 0){
            return null;
        }
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            if (i % 3 == 0 && i % 5 == 0){
                list.add("FizzBuzz");
            }else if(i % 3 == 0){
                list.add("Fizz");
            }else if (i % 5 == 0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
