package WrittenExamination.XiaoMi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/9/6 20:28
 * @Version 1.0
 **/
public class Main2 {
    static int solution(int[] prices, int budget) {
        Arrays.sort(prices);
        int res = 0;
        while (budget> 0){
            budget = budget - prices[prices.length-1];
            res++;
        }
        return res;

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
