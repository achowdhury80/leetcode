package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob543 {
	/**
	 * O(N), since it goes through each node and O(H) recursion stack size is
	 * proportional to tree height
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
        return helper(root)[0];
    }
	
	/**
	 * 1st element is the max diameter,; may or may not include root
	 * 2nd element is the biggest root to leaf path length
	 * @param root
	 * @return
	 */
	private int[] helper(TreeNode root) {
		// if null diameter 0 and path is -1, because for a leaf node path is 0
        if (root == null) return new int[] {0, -1};
        int[] left = helper(root.left), right = helper(root.right);
        int[] result = new int[2];
        // find the max of diameter of left and right subtree
        result[0] = Math.max(left[0], right[0]);
        // max diameter is max of left, right or sum of biggest path to left and 
        // to right including root 
        result[0] = Math.max(result[0],  2 + left[1] + right[1]);
        result[1] = Math.max(1 + left[1], 1 + right[1]);
        return result;
    }
}
