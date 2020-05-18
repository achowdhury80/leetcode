package comp.prep2019;

public class Prob1373 {
	public int maxSumBST(TreeNode root) {
        int[] result = new int[1];
        helper(root, result);
        return result[0];
    }
	
	private SubtreeData helper(TreeNode root, int[] result) {
		if (root == null) return new SubtreeData(true, 0, 0, 0);
		SubtreeData left = null, right = null;
		if (root.left != null) left = helper(root.left, result);
		if (root.right != null) right = helper(root.right, result);
		if (left != null && (!left.isBst || left.max >= root.val) 
				|| right != null && (!right.isBst || right.min <= root.val))
			return new SubtreeData(false, 0, 0, 0);
		int sum = (left != null ? left.sum : 0) + root.val 
				+ (right != null ? right.sum : 0);
		result[0] = Math.max(result[0], sum);
		return new SubtreeData(true, left != null ? left.min : root.val, 
				right != null ? right.max : root.val, sum);
		
	}
	
	class SubtreeData {
		boolean isBst;
		int max, min, sum;
		SubtreeData(boolean isBst, int min, int max, int sum) {
			this.isBst = isBst;
			this.max = max;
			this.min = min;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(4);
		t1.right = new TreeNode(6);
		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(2);
		t2.right = t1;
		TreeNode t3 = new TreeNode(4);
		t3.left = new TreeNode(2);
		t3.right = new TreeNode(4);
		TreeNode root = new TreeNode(1);
		root.left = t3;
		root.right = t2;
		Prob1373 prob = new Prob1373();
		System.out.println(prob.maxSumBST(root));
	}
}
