package comp.prep2019;

public class Prob333 {
	public int largestBSTSubtree(TreeNode root) {
		int[] result = new int[1];
		findBSTNMinMax(root, result);
		return result[0];
    }
	
	/**
	 * returns - 1st element size. -1 means not bst, 2nd element min and 3rd element is max
	 * @param root
	 * @param result
	 * @return
	 */
	private int[] findBSTNMinMax(TreeNode root, int[] result) {
		if (root == null) return new int[] {0, 0, 0};
		int[] leftSub = findBSTNMinMax(root.left, result);
		int[] rightSub = findBSTNMinMax(root.right, result);
		if (leftSub[0] == -1 || rightSub[0] == -1) return new int[] {-1, 0, 0};
		//if (leftSub[0] == 0 && rightSub[0] == 0) return new int[] {1, root.val, root.val};
		if (leftSub[0] != 0 && leftSub[2] >= root.val || rightSub[0] != 0 
				&& rightSub[1] <= root.val) return new int[] {-1, 0, 0}; 
		int size = leftSub[0] + 1 + rightSub[0];
		result[0] = Math.max(result[0], size);
		return new int[] {size, leftSub[0] == 0 ? root.val : leftSub[1], 
				rightSub[0] == 0 ? root.val : rightSub[2]};
	}
	
	public static void main(String[] args) {
		Prob333 prob = new Prob333();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		
	}
}
