package comp.prep2019;

public class Prob783 {
	/**
	 * O(N) & O(H) space for recursion stack
	 * helper finds out minDiff, min and max value of a subtree
	 * @param root
	 * @return
	 */
	public int minDiffInBST(TreeNode root) {
        return helper(root)[0];
    }
	
	/**
	 * arr[0] minimum of the tree
	 * arr[1] leftMost Node value
	 * arr[2] rightMost node value
	 * @param root
	 * @return
	 */
	private int[] helper(TreeNode root) {
		int[] leftArr = null, rightArr = null;
		int[] result = new int[] {Integer.MAX_VALUE, root.val, root.val};
        if (root.left != null) {
        	leftArr = helper(root.left);
        	result[1] = leftArr[1];
        	result[0] = Math.min(root.val - leftArr[2], leftArr[0]);
        }
        if(root.right != null) {
        	rightArr = helper(root.right);
        	result[2] = rightArr[2];
        	result[0] = Math.min(result[0], rightArr[0]);
        	result[0] = Math.min(result[0], rightArr[1] - root.val);
        }
        return result;
    }
}
