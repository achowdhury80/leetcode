package comp.prep2019;

public class Prob1008 {
	public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
	
	private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        TreeNode root = new TreeNode(preorder[start]);
        if (start == end) return root;
        int i = start;
        while(i < end && preorder[i + 1] < preorder[start]) i++;
        if (i > start) root.left = bstFromPreorder(preorder, start + 1, i);
        if (i < end) root.right = bstFromPreorder(preorder, i + 1, end);
        return root;
    }
}
