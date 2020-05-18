package comp.prep2019;

public class Prob106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length < 1) return null;
		return constructFromPostIn(inorder, postorder, 0, 0, postorder.length);
    }
	
	private TreeNode constructFromPostIn(int[] inOrder, int[] postOrder, int inOrderStart, int postStart, int len) {
        TreeNode root = new TreeNode(postOrder[postStart + len - 1]);
        if (len == 1) return root;
        int rootIndex = findIndex(inOrder, inOrderStart, inOrderStart + len - 1, root.val);
        int leftSubtreeLength = rootIndex - inOrderStart;
        if (leftSubtreeLength != 0) {
        	root.left = constructFromPostIn(inOrder, postOrder, inOrderStart, postStart, leftSubtreeLength);
        }
        if (len <= leftSubtreeLength + 1) return root;
        root.right = constructFromPostIn(inOrder, postOrder, rootIndex + 1, postStart + leftSubtreeLength, len - leftSubtreeLength - 1);
        return root;
	}
	
	private int findIndex(int[] arr, int start, int end, int val) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == val) return i;
		}
		return -1;
	}
}
