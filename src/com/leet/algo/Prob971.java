package com.leet.algo;
import java.util.*;
public class Prob971 {
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> result = new ArrayList<>();
		if(voyage == null || voyage.length ==0)
			return result;
		boolean[] hasError = new boolean[1];
		int[] idx = new int[] {0};
		helper(root,voyage, hasError, result, idx);
		return result;
	}

	public void helper(TreeNode root, int[] voyage, boolean[] hasError, List<Integer> result, int[] idx){
		if(root == null || hasError[0])
			return;

		if(voyage[idx[0]]!=root.val){
			error(hasError, result);
			return;
		}

		idx[0]++;

		// Case 1 : When node has both left and right child
		if(root.left!=null && root.right!=null){
			// Case A when swap is aplicable
			if(voyage[idx[0]]==root.right.val){
				helper(root.right,voyage, hasError, result, idx);
				if(voyage[idx[0]]==root.left.val && !hasError[0]){
					result.add(root.val);
					helper(root.left,voyage, hasError, result, idx);
				}
			}
			// Case B when swap is not aplicable
			else{
				helper(root.left,voyage, hasError, result, idx);
				if(!hasError[0])  helper(root.right,voyage, hasError, result, idx);
			}
		}
		// Case 2 : When node has either left or right child
		else if(root.left!=null || root.right!=null){
			Integer curr = (root.left!=null)?root.left.val:root.right.val;
			if(voyage[idx[0]]!=curr){
				 error(hasError, result);
				 return;
			}else{
			   helper((root.left!=null)?root.left:root.right,voyage, hasError, result, idx); 
			}
		}

	}

	public void error(boolean[] hasError, List<Integer> result){
		hasError[0] = true;
		result.clear();
		result.add(-1);
	}
	public static void main(String[] args) {
		Prob971 prob = new Prob971();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(prob.flipMatchVoyage(root, new int[] {1, 3, 2}));
		System.out.println(prob.flipMatchVoyage(root, new int[] {1, 2, 3}));
	}
}
