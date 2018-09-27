package Easy;


/**
 * 你正在爬楼梯。它需要n步才能达到顶峰。
 每次你可以爬1或2步。您可以通过多少不同的方式登顶？
 * @author WilsonSong
 * @date 2018/9/27/027
 */
public class ClimbingStairs {

    //用动态规划时间复杂度太高了？？？？？
    public static int climbStairs(int n) {
        if (n==0){
            return 1;
        }else if (n < 0){
            return 0;
        }
        return  (climbStairs(n-1)) + (climbStairs(n-2));
    }

    //Basically it's a fibonacci.
//    如果n <= 0，则路数应为零。
//如果n == 1，那么只有爬楼梯的方法。
//如果n == 2，那么有两种方法可以爬楼梯。一个解决方案是一步一个接一个; 另一个是一次两个步骤。
//
//解决这个问题的关键直觉是，给定一定数量的阶梯n，如果我们知道到达各个点的数量[n-1]，[n-2]分别表示为n1和n2，
// 那么达到这一点的总方法[n]是n1 + n2。因为从这[n-1]一点来说，我们可以采取一个步骤来实现[n]。
// 从这[n-2]一点来说，我们可以采取两个步骤来实现目标。这两个解决方案集之间没有重叠，因为我们在最后一步中有所不同。
//    现在给出上述直觉，可以构造一个数组，其中每个节点存储每个数字n的解。或者如果我们仔细观察它，
// 很明显这基本上是一个斐波纳契数，起始数为1和2，而不是1和1。
//    这种方法是递归的本质 问题和找数组中具有最大和的连续子数组很像
   public static int climbStairs2(int n){
        if (n == 1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <=n; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
    public static void main(String[] args){
        System.out.println(climbStairs2(1));
    }


}
