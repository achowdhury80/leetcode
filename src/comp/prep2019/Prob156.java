package comp.prep2019;

public class Prob156 {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        return upsideDownBinaryTreeWithRootNRightMost(root)[0];
    }
	
	private TreeNode[] upsideDownBinaryTreeWithRootNRightMost(TreeNode root) {
        if (root == null) return new TreeNode[] {null, null};
        if (root.left == null) return new TreeNode[] {root, root};
        TreeNode[] leftConverted = upsideDownBinaryTreeWithRootNRightMost(root.left);
        leftConverted[1].left = root.right;
        leftConverted[1].right = root;
        root.left = null;
        root.right = null;
        return new TreeNode[] {leftConverted[0], root};
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
