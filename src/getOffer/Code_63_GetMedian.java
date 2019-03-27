package getOffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @program:
 * @description:
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 * @author: Song
 * @create: Created in 2019-03-27 16:55
 * @Modified by:
 **/
public class Code_63_GetMedian {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public void Insert(Integer num) {
        arrayList.add(num);
    }

    public Double GetMedian() {
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (arrayList.size() % 2 == 0){
            int mid = arrayList.size();
            return (double) (arrayList.get(mid) + arrayList.get(mid -1)) / 2;
        }else {
            return (double) arrayList.get(arrayList.size()/2);
        }
    }
}
