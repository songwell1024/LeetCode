package getOffer;

/**
 * @program:
 * @description:
 * 1+2+3+...+n
 * @author: Song
 * @create: Created in 2019-03-23 18:13
 * @Modified by:
 **/
public class Code_47_Sum_Solution {
    public int Sum_Solution(int n) {
        if (n == 0){
            return 0;
        }
        return n + Sum_Solution(n-1);
    }
}
