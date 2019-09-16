package medium;

import java.awt.image.Kernel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName Code_101_ConstructBinaryTreefromPreorderAndInorderTraversal
 * @Description: 根据前序和中序遍历建立二叉树
 * @Author Song
 * @Date 2019/4/11 17:00
 * @Version 1.0
 **/
public class Code_101_ConstructBinaryTreefromPreorderAndInorderTraversal {
    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        ArrayList<Integer> leftPreList = new ArrayList<>();
        ArrayList<Integer> leftInList = new ArrayList<>();
        ArrayList<Integer> rightPreList = new ArrayList<>();
        ArrayList<Integer> rightInList = new ArrayList<>();
        int k = 0;
        while (inorder[k] != preorder[0]){
            leftInList.add(inorder[k]);
            leftPreList.add(preorder[k+1]);
            k++;
        }
        k++;
        while ( k < inorder.length){
            rightInList.add(inorder[k]);
            rightPreList.add(preorder[k]);
            k++;
        }
        int[] leftPreNum = new int[leftPreList.size()];
        int[] leftInNum = new int[leftPreList.size()];
        for (int i = 0; i < leftPreList.size(); i++){
            leftPreNum[i] = leftPreList.get(i);
            leftInNum[i] = leftInList.get(i);
        }
        int[] rightPreNum = new int[rightInList.size()];
        int[] rightInNum = new int[rightInList.size()];
        for (int i = 0; i < rightInNum.length; i++){
            rightInNum[i] = rightInList.get(i);
            rightPreNum[i] = rightPreList.get(i);
        }
        root.left = buildTree(leftPreNum, leftInNum);
        root.right = buildTree(rightPreNum, rightInNum);
        return root;
    }
    public static int hou(List<Integer> list){
        if (list.size() == 1){
            return list.get(0);
        }
        List<Integer> list1 =new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if ((i +1)%2 != 0){
                list1.add(list.get(i));
            }
        }
        return hou(list1);
    }

    public static void main(String args[]){
        dunc(1000);
    }

//    public static void main(String[] args) {
////        List<Integer> list =new ArrayList<>();
////        for (int i = 1; i<=305; i++){
////            list.add(i);
////        }
////
////        System.out.println( hou(list));
//        if((" \d+\.?\d*").equals("12.5")){
//
//        }
//    }
    public static int dunc(int n){
        int i = 1, sum =1;
        while (sum < n) {sum+= ++i;
        System.out.println(i);}
        return i;
    }

}
