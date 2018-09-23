package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author WilsonSong
 * @date 2018/6/30/030
 */
public class Roman2Integer {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int output = 0;

        for (int i = 0; i< s.length()-1; ++i){
            if (s !=null){
                if (map.get(String.valueOf(s.charAt(i)))>= map.get(String.valueOf(s.charAt(i+1)))){
                    output += map.get(String.valueOf(s.charAt(i))) ;
                }else {
                    output +=  - map.get(String.valueOf(s.charAt(i)));
                }
            }

        }
        return output + map.get(String.valueOf(s.charAt(s.length()-1))) ;
    }

//另一种方法
//    public int romanToInt(String s) {
//        int nums[]=new int[s.length()];
//        for(int i=0;i<s.length();i++){
//            switch (s.charAt(i)){
//                case 'M':
//                    nums[i]=1000;
//                    break;
//                case 'D':
//                    nums[i]=500;
//                    break;
//                case 'C':
//                    nums[i]=100;
//                    break;
//                case 'L':
//                    nums[i]=50;
//                    break;
//                case 'X' :
//                    nums[i]=10;
//                    break;
//                case 'V':
//                    nums[i]=5;
//                    break;
//                case 'I':
//                    nums[i]=1;
//                    break;
//            }
//        }
//        int sum=0;
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]<nums[i+1])
//                sum-=nums[i];
//            else
//                sum+=nums[i];
//        }
//        return sum+nums[nums.length-1];
//    }
}
