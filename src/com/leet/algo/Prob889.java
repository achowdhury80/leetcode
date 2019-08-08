package com.leet.algo;

public class Prob889 {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }
	
	private TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
		if (preStart == preEnd) return new TreeNode(pre[preStart]);
		TreeNode result = new TreeNode(pre[preStart]);
		int leftPostEnd = -1;
		for (int i = postStart; i <= postEnd; i++) {
			if (post[i] == pre[preStart + 1]) {
				leftPostEnd = i;
				break;
			}
		}
		result.left = constructFromPrePost(pre, post, preStart + 1, preStart + leftPostEnd - postStart + 1, postStart, leftPostEnd);
		if (leftPostEnd != postEnd - 1) {
			result.right = constructFromPrePost(pre, post, preStart + leftPostEnd - postStart + 2, preEnd, leftPostEnd + 1, postEnd - 1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob889 prob = new Prob889();
		TreeNode t = prob.constructFromPrePost(new int[] {1,2,4,5,3,6,7}, new int[] {4,5,2,6,7,3,1});
		System.out.println(t);
	}
}
