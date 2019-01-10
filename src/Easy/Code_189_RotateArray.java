/**
 * 
 * @author songzhiyong
 * 往前挪就可以了，挪l -k + 1步
 *Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

public class Code_189_RotateArray {
	
	 public static void rotate(int[] nums, int k) {
		 k =k % nums.length;
		 int cur = nums.length - k;
		 int kk = cur -1;
		 int help = kk;
		 while(cur < nums.length){
			 int i = cur;
			 while(kk >= 0){
				 swap(nums,cur,cur-1);
				 kk --;
				 cur --;
			 }
			 cur = i + 1;
			 kk = help;
		 }
	 }
	 
	 public static void swap(int[] nums, int i, int j){
		 int index = nums[i];
		 nums[i] = nums[j];
		 nums[j] = index;
		 
	 }
	 
	 public static void main(String[] args){
		 int[] nums = {1,2,3,4,5,6,7};
		 rotate(nums,5);
		 System.out.println("aa");
	 }

}
