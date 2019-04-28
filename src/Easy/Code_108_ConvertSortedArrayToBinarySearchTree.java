package Easy;



import javax.swing.table.TableRowSorter;

/**
 * 将排序数组转换为二分搜索树
 * @author WilsonSong
 * @date 2019/1/7/007
 */
public class Code_108_ConvertSortedArrayToBinarySearchTree {

    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;

        public int val;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head =null;
        head = process(nums, 0, nums.length -1);
        return head;
    }

    public static TreeNode process( int[] nums,int l, int r){
        if (l == r ){
            return new TreeNode(nums[l]);
        }
        if (l < r){
            int mid = l + (r -l)/2;
            TreeNode head = new TreeNode(nums[mid]);
            head.left = process(nums, l, mid-1);
            head.right = process(nums, mid +1,r);
            return head;
        }else {
            return null;
        }
    }

    public static void main(String[] args){

        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
        System.out.println(111);

    }


}
