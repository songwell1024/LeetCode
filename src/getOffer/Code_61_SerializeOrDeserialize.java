package getOffer;

/**
 * @program:
 * @description:
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * @author: Song
 * @create: Created in 2019-03-27 16:26
 * @Modified by:
 **/
public class Code_61_SerializeOrDeserialize {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    int index = 0;
    String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if (root == null){
            str.append("#,");
            return str.toString();
        }
        str.append(root.val + ",");
        str.append(Serialize(root.left));
        str.append(Serialize(root.right));
        return str.toString();
    }
    TreeNode Deserialize(String str) {
        String[] node = str.split(",");
        TreeNode root = null;
        if (index < node.length &&!node[index].equals("#")){
            root = new TreeNode(Integer.parseInt(node[index]));
            index++;
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }

    /*
        算法思想：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
        依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
        另外，结点之间的数值用逗号隔开。
    */
    public class Solution {
        int index = -1;   //计数变量

        String Serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if(root == null){
                sb.append("#,");
                return sb.toString();
            }
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
            return sb.toString();
        }
        TreeNode Deserialize(String str) {
            index++;
            String[] strr = str.split(",");
            TreeNode node = null;
            if(!strr[index].equals("#")){
                node = new TreeNode(Integer.valueOf(strr[index]));
                node.left = Deserialize(str);
                node.right = Deserialize(str);
            }
            return node;
        }
    }
}
