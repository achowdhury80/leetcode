package comp.prep2019;

public class Prob1448 {
	public int goodNodes(TreeNode root) {
        int[] result = new int[] {0};
        helper(root, root.val, result);
        return result[0];
    }
	
	private void helper(TreeNode root, int max, int[] result) {
		if (root == null) return;
		if (root.val >= max) {
			max = root.val;
			result[0]++;
		}
		helper(root.left, max, result);
		helper(root.right, max, result);
	}
}
