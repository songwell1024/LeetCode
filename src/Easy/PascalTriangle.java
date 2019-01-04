package AdvancedDemo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角，给出一个n,返回前n行的杨辉三角排列
 * 杨辉三角其实就是一个数的和等于他上面两个数的和
 * @author WilsonSong
 * @date 2018/10/23/023
 */
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <=0){
           return res;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        res.add(list);
        for (int i = 2; i <= numRows; i++){
            List<Integer> listCur = new ArrayList<>();
            listCur.add(1);
            for (int j = 2; j < i; j++){
                listCur.add(list.get(j-2) + list.get(j-1));
            }
            listCur.add(1);
            res.add(listCur);
            list = listCur;
        }
        return res;
    }

    public static void main(String[] args){
        generate(5);
    }
}
