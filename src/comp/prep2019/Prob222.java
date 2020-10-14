package comp.prep2019;
public class Prob222 {
	public int countNodes(TreeNode root) {
		int h = findHeight(root);
		return h == -1 ? 0 : (findHeight(root.right) == h - 1 
				? ((1 << h) + countNodes(root.right))
				: ((1 << (h - 1)) + countNodes(root.left)));
	}
	
	private int findHeight(TreeNode root) {
		return root == null ? -1 : 1 + findHeight(root.left);
	}
}
