package comp.prep2019;

public class Prob1430 {
	public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, 0, arr);
    }
	
	private boolean helper(TreeNode root, int start, int[] arr) {
		if (root == null || root.val != arr[start]) return false;
		if (start == arr.length - 1) {
			if (root.left == null && root.right == null) return true;
			return false;
		}
		return helper(root.left, start + 1, arr) 
				|| helper(root.right, start + 1, arr);
	}
}
