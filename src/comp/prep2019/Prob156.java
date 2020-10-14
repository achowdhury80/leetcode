package comp.prep2019;

public class Prob156 {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        return helper(root)[0];
    }
	
	private TreeNode[] helper(TreeNode root) {
		if (root == null) return new TreeNode[2];
		if (root.left == null && root.right == null) 
			return new TreeNode[] {root, root};
		TreeNode[] left = helper(root.left);
		left[1].right = root;
		left[1].left = root.right;
		root.left = null;
		root.right = null;
		return new TreeNode[] {left[0], 
				left[1].right == null ? left[1] : left[1].right};
	}
	
	public static void main(String[] args) {
		Prob156 prob = new Prob156();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode result = prob.upsideDownBinaryTree(root);
		System.out.println(root);
	}
}
