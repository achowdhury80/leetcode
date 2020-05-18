package comp.prep2019;

public class Prob1120 {
	public double maximumAverageSubtree(TreeNode root) {
		double[] ans = new double[1];
		findSumNCount(root, ans);
		return ans[0];
    }
	
	private int[] findSumNCount(TreeNode root, double[] maxAvg) {
		int[] result = new int[2];
		if (root.left != null) {
			result = findSumNCount(root.left, maxAvg);
		}
		if (root.right != null) {
			int[] temp = findSumNCount(root.right, maxAvg);
			result[0] += temp[0];
			result[1] += temp[1];
		}
		result[0] += root.val;
		result[1]++;
		maxAvg[0] = Math.max(maxAvg[0], (0.0 + result[0])/result[1]);
		return result;
	}
}
