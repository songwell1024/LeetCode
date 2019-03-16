package getOffer;

import java.util.ArrayList;

/**
 * @program:
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 最后一个数是根，肯定是最小的，然后左子树都是小于根的，右子树都是大于根的，然后左子树右子树递归
 * @author: Song
 * @create: Created in 2019-03-14 19:40
 * @Modified by:
 **/
public class Code_23_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null ){
            return true;
        }
        if (sequence.length ==1){
            return true;
        }
        if (sequence.length == 0){
            return false;
        }
        ArrayList<Integer> arrayListL = new ArrayList<>();
        ArrayList<Integer> arrayListR = new ArrayList<>();
        int mid = sequence[sequence.length -1];
        int start = 0;
        while (sequence[start] < mid){
            arrayListL.add(sequence[start]);
            start++;
        }
        while (sequence[start] > mid){
            arrayListR.add(sequence[start]);
            start++;
        }
        if (start != sequence.length -1){
            return false;
        }
        int[] L = new int[arrayListL.size()];
        for (int i = 0; i < arrayListL.size(); i++){
            L[i] = arrayListL.get(i);
        }

        int[] R = new int[arrayListR.size()];
        for (int i = 0; i < arrayListR.size(); i++){
            R[i] = arrayListR.get(i);
        }
        if (L.length > 0 && R.length > 0){
            return VerifySquenceOfBST(L)&& VerifySquenceOfBST(R);
        }else if (L.length > 0){
            return VerifySquenceOfBST(L);
        }else if (R.length > 0){
            return VerifySquenceOfBST(R);
        }
        return false;
    }
}
