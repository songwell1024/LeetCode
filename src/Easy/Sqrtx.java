package Easy;


/**
 * 计算并返回x的平方根，其中  x  保证为非负整数。
 * @author WilsonSong
 * @date 2018/9/27/027
 */
public class Sqrtx {

    public static int mySqrt(int x) {
        return (int)Math.floor(Math.sqrt(x));
    }

    //一个小技巧是使用i <= x / i进行比较，而不是i * i <= x，以避免超过整数上限。
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x / i; i++)
            if (i <= x / i && (i + 1) > x / (i + 1))// Look for the critical point: i*i <= x && (i+1)(i+1) > x
                return i;
        return -1;
    }

    //牛顿解决方案
    //其公式就是 x(n+1) = (x(n) + a/x(n))/2  其中x为逼近的解,a为被开方的函数
    //找到x > a/x的时候就可以停止了，因为这个时候就是x*x最接近a的时候
    public int mySqrt3(int x) {
        if (x == 0) return 0;
        long i = x;
        while(i > x / i)
            i = (i + x / i) / 2;
        return (int)i;
    }

    //二进制搜索解决方案
    //其实就是折半的向最接近的值找
    public int mySqrt4(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

    public static void main(String[] args){
        System.out.println(mySqrt(8));
    }

}
