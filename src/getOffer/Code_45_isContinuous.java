package getOffer;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-03-23 15:19
 * @Modified by:
 **/
public class Code_45_isContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length <= 1){
            return true;
        }
        ArrayList<Integer> list = new ArrayList();
        for (int num: numbers){
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 -o2;
            }
        });
        int flag = 0;
        for (int i = 0; i < list.size() - 1; i++){
            if (flag < 0){
                return false;
            }
            if (list.get(i) == 0){
                flag++;
            }else if (list.get(i + 1) - list.get(i) == 1){

            }else if (list.get(i + 1) - list.get(i) > 1){
                flag -=( list.get(i + 1) - list.get(i) -1);
                if (flag < 0){
                    return false;
                }
            }else if (list.get(i+1) == list.get(i)){
                return false;
            }
        }
        return true;
    }

}
