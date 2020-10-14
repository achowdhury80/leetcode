package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1008 {
	/**
	 * O(N) time and O(N) space
	 * @param preorder
	 * @return
	 */
	public TreeNode bstFromPreorder(int[] preorder) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		for (int i = 1; i < preorder.length; i++) {
			TreeNode node = new TreeNode(preorder[i]);
			if (stack.peek().val > node.val) {
				stack.peek().left = node;
				stack.push(node);
			} else {
				TreeNode parent = stack.pop();
				while(!stack.isEmpty() && stack.peek().val < node.val) {
					parent = stack.pop();
				}
				parent.right = node;
				stack.push(node);
			}
				
		}
        return root;
    }
	
	public TreeNode bstFromPreorder1(int[] preorder) {
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
