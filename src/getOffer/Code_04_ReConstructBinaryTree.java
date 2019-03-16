package getOffer;

import java.util.ArrayList;

/**
 * @program:
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *我们基于一个事实：中序遍历一定是 { 左子树中的节点集合 }，root，{ 右子树中的节点集合 }，前序遍历的作用就是找到每颗子树的root位置。
 * 输入：前序遍历，中序遍历
 * 1、寻找树的root，前序遍历的第一节点G就是root。
 * 2、观察前序遍历GDAFEMHZ，知道了G是root，剩下的节点必然在root的左或右子树中的节点。
 * 3、观察中序遍历ADEFGHMZ。其中root节点G左侧的ADEF必然是root的左子树中的节点，G右侧的HMZ必然是root的右子树中的节点，root不在中序遍历的末尾或开始就说明根节点的两颗子树都不为空。
 * 4、观察左子树ADEF，按照前序遍历的顺序来排序为DAFE，因此左子树的根节点为D，并且A是左子树的左子树中的节点，EF是左子树的右子树中的节点。
 * 5、同样的道理，观察右子树节点HMZ，前序为MHZ，因此右子树的根节点为M，左子节点H，右子节点Z。
 * @author: Song
 * @create: Created in 2019-03-11 15:10
 * @Modified by:
 **/
public class Code_04_ReConstructBinaryTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0){
            return null;
        }
        ArrayList<Integer> preLeft = new ArrayList<>();
        ArrayList<Integer> preRight = new ArrayList<>();
        ArrayList<Integer> inLeft = new ArrayList<>();
        ArrayList<Integer> inRight = new ArrayList<>();
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        while (in[index] != pre[0] && index < pre.length){
            inLeft.add(in[index]);
            preLeft.add(pre[++index]);
        }
        index ++;
        while (index < pre.length){
            inRight.add(in[index]);
            preRight.add(pre[index++]);
        }
        root.left = reConstructBinaryTree(objectArrayToInt(preLeft),objectArrayToInt(inLeft));
        root.right = reConstructBinaryTree(objectArrayToInt(preRight),objectArrayToInt(inRight));
        return root;
    }

    public static int[] objectArrayToInt(ArrayList<Integer> list){
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre, in);

    }
}
