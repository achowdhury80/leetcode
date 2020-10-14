package comp.prep2019;

public class Prob979 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @return
	 */
	public int distributeCoins(TreeNode root) {
        int[] move = new int[1];
        findNeeded(root, move);
        return move[0];
    }
	
	/**
	 * negative for outgoing
	 * @param root
	 * @param move
	 * @return
	 */
	private int findNeeded(TreeNode root, int[] move) {
		if (root == null) return 0;
		int leftIncoming = findNeeded(root.left, move);
		int rightIncoming = findNeeded(root.right, move);
		int totalIncoming = leftIncoming + rightIncoming;
		move[0] += Math.abs(totalIncoming + root.val - 1);
		return totalIncoming + root.val - 1;
	}
}
