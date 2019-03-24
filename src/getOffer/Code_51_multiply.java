package getOffer;

/**
 * @program:
 * @description:
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author: Song
 * @create: Created in 2019-03-24 14:38
 * @Modified by:
 **/
public class Code_51_multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int help = 1;
        //B[i] = A[i] *A[i+1] *...*A[n]
        for (int i = A.length -1; i >=0; i--){
            B[i] = A[i] * help;
            help *= A[i];
        }

        help = 1;
        //B[i] = B[i + 1] * A[0] *...*A[i -1]
        for (int i = 0; i < A.length -1; i ++){
            B[i] = B[i+1] * help;
            help *= A[i];
        }
        B[B.length -1] = help;
        return B;
    }
}
