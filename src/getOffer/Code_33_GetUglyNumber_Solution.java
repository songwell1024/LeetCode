package getOffer;

import java.util.ArrayList;

/**
 * @program:
 * @description:
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 其实就是维护3个指针
 *
 *
 * 1）1
 * |2
 * |3
 * |5
 * 目前指针指向0,0,0，队列头arr[0] * 2 = 2,  arr[0] * 3 = 3,  arr[0] * 5 = 5
 * （2）1 2
 * 2 |4
 * |3 6
 * |5 10
 * 目前指针指向1,0,0，队列头arr[1] * 2 = 4,  arr[0] * 3 = 3, arr[0] * 5 = 5
 * （3）1 2 3
 * 2| 4 6
 * 3 |6 9
 * |5 10 15
 * 目前指针指向1,1,0，队列头arr[1] * 2 = 4,  arr[1] * 3 = 6, arr[0] * 5 = 5
 * @author: Song
 * @create: Created in 2019-03-20 16:42
 * @Modified by:
 **/
public class Code_33_GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7){
            return index;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int num;
        while (arrayList.size() <= index){
            num = Math.min(arrayList.get(t1)* 2, Math.min(arrayList.get(t2) * 3, arrayList.get(t3) *5));
            arrayList.add(num);
            if (arrayList.get(t1)*2 == num) t1++;
            if (arrayList.get(t2)*3 == num) t2++;
            if (arrayList.get(t3)*5 == num) t3++;
        }
        return arrayList.get(index -1);

    }
}
