package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length < 1) return null;
		return constructFromPreIn(preorder, inorder, 0, 0, preorder.length);
    }
	
	private TreeNode constructFromPreIn(int[] pre, int[] inOrder, int preStart, int inOrderStart, int len) {
        TreeNode root = new TreeNode(pre[preStart]);
        if (len == 1) return root;
        int rootIndex = findIndex(inOrder, inOrderStart, inOrderStart + len - 1, root.val);
        int leftSubtreeLength = rootIndex - inOrderStart;
        if (leftSubtreeLength != 0) {
        	root.left = constructFromPreIn(pre, inOrder, preStart + 1, inOrderStart, leftSubtreeLength);
        }
        if (len <= leftSubtreeLength + 1) return root;
        root.right = constructFromPreIn(pre, inOrder, preStart + leftSubtreeLength + 1, rootIndex + 1, len - leftSubtreeLength - 1);
        return root;
	}
	
	private int findIndex(int[] arr, int start, int end, int val) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == val) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Prob105 prob = new Prob105();
		TreeNode root = prob.buildTree(new int[] {1,2,3},
				new int[] {3, 2, 1});
	}
}
