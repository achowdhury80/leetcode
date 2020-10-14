package comp.prep2019;

public class Prob776 {
	/**
	 * O(N) time and o(H) space
	 * returns array of smaller subtree first and then the other
	 * @param root
	 * @param V
	 * @return
	 */
	public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
        	return new TreeNode[] {null, null};
        }
        if (root.val > V) {
        	TreeNode[] nodes = splitBST(root.left, V);
        	root.left = nodes[1];
        	return new TreeNode[] {nodes[0], root};
        } else {
        	TreeNode[] nodes = splitBST(root.right, V);
        	root.right = nodes[0];
        	return new TreeNode[] {root, nodes[1]};
        }
    }
	
	public static void main(String[] args) {
		Prob776 prob = new Prob776();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		System.out.println(prob.splitBST(root, 2));
	}
}
	