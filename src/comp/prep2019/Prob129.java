package comp.prep2019;

public class Prob129 {
	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
        return sumNumbers(root, 0);
    }
	
	private int sumNumbers(TreeNode root, int prev) {
        int temp = prev * 10 + root.val;
        if (root.left == null && root.right == null) return temp;
        int sum = 0;
        if (root.left != null) sum += sumNumbers(root.left, temp);
        if (root.right != null) sum += sumNumbers(root.right, temp);
        return sum;
    }
}
