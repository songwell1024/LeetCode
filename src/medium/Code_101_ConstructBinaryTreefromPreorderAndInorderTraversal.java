package medium;

import java.awt.image.Kernel;
import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        buildTree(pre, in);
    }
}
