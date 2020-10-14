package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob110 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
       return  findBalancedNHeight(root)[0] == 1;
    }
	
	/**
	 * returns an array
	 * 1st element 0 means not balanced and 1 means balanced
	 * 2nd elements denotes the height
	 * check left is balanced
	 * check right is balanced
	 * check the diff in height less than 2
	 * @param root
	 * @return
	 */
	private int[] findBalancedNHeight(TreeNode root) {
		if (root == null) return new int[] {1, 0};
		int[] left = findBalancedNHeight(root.left);
		if(left[0] != 1) return new int[] {0, 0};
		int[] right = findBalancedNHeight(root.right);
		if(right[0] != 1) return new int[] {0, 0};
		return new int[] {Math.abs(left[1] - right[1]) > 1 ? 0 : 1, 1 + Math.max(left[1], right[1])};
	}
}
