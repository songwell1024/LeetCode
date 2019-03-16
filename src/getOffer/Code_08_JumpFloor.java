package getOffer;

/**
 * @program:
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @author: Song
 * @create: Created in 2019-03-11 16:59
 * @Modified by:
 **/
public class Code_08_JumpFloor {

    public int JumpFloor(int target) {
        if (target == 0){
            return 1;
        }
        if (target == 1){
            return 1;
        }
        return JumpFloor(target -1) + JumpFloor(target -2);
    }

}
