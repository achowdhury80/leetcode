package comp.prep2019;

public class Prob298 {
	public int longestConsecutive(TreeNode root) {
        int[] result = new int[1];
        longestConsecutive(root, result);
        return result[0];
    }
	
	private int longestConsecutive(TreeNode root, int[] result) {
        if (root == null) return 0;
        int leftCons = longestConsecutive(root.left, result);
        int path = 0;
        if (root.left != null && root.val + 1 == root.left.val) path = leftCons;
        int rightCons = longestConsecutive(root.right, result);
        if (root.right != null && root.val + 1 == root.right.val && rightCons > path) {
        	path = rightCons;
        }
        result[0] = Math.max(result[0], 1 + path);
        return 1 + path;
    }
	
	public static void main(String[] args) {
		Prob298 prob = new Prob298();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(prob.longestConsecutive(root));
	}
}
