package comp.prep2019;

public class Prob889 {
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, 0, pre.length);
    }
	
	private TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int postStart, int len) {
        TreeNode root = new TreeNode(pre[preStart]);
        if (len == 1) return root;
        int leftVal = pre[preStart + 1];
        int leftIndexInPost = findIndex(post, postStart, postStart + len - 2, leftVal);
        int leftSubtreeLength = leftIndexInPost - postStart + 1;
        root.left = constructFromPrePost(pre, post, preStart + 1, postStart, leftSubtreeLength);
        if (len <= leftSubtreeLength + 1) return root;
        root.right = constructFromPrePost(pre, post, preStart + leftSubtreeLength + 1, postStart + leftSubtreeLength, len - leftSubtreeLength - 1);
        return root;
	}
	
	private int findIndex(int[] arr, int start, int end, int val) {
		for (int i = start; i <= end; i++) {
			if (arr[i] == val) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Prob889 prob = new Prob889();
		TreeNode root = prob.constructFromPrePost(new int[] {1,2,4,5,3,6,7},
				new int[] {4,5,2,6,7,3,1});
	}
}
