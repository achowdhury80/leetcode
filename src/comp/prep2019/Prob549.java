package comp.prep2019;

public class Prob549 {
	public int longestConsecutive(TreeNode root) {
		int[] result = new int[1];
        longestConsecutive(root, result);
        return result[0];
    }
	
	/**
	 * 0th element gives increasing seq count and 1st element gives decresing sequence count
	 * @param root
	 * @param result
	 * @return
	 */
	private int[] longestConsecutive(TreeNode root, int[] result) {
		if (root == null) return new int[]{0, 0};
	    int incr = 1, decr = 1;
	    int[] l = longestConsecutive(root.left, result);
	    int[] r = longestConsecutive(root.right, result);
	    if (root.left != null) {
	      if (root.left.val == root.val + 1) incr = l[0] + 1;
	      else if (root.left.val + 1 == root.val) decr = l[1] + 1;
	    }
	    if (root.right != null) {
	      if (root.right.val == root.val + 1) incr = Math.max(incr, r[0] + 1);
	      else if (root.right.val + 1 == root.val) decr = Math.max(decr, r[1] + 1);
	    }
	    result[0] = Math.max(result[0], incr + decr - 1);
	    return new int[]{incr, decr};
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		Prob549 prob = new Prob549();
		System.out.println(prob.longestConsecutive(root));
	}
}
