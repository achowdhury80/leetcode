package comp.prep2019;

public class Prob1367 {
	public boolean isSubPath(ListNode head, TreeNode root) {
		if (root == null) return false;
        if (hasPathStartingFromRoot(head, root)) return true;
        return isSubPath(head, root.left)
        		|| isSubPath(head, root.right);
    }
	
	private boolean hasPathStartingFromRoot(ListNode head, TreeNode root) {
		if (head == null) return true;
		if(root == null) return false;
		if (head.val != root.val) return false;
		return hasPathStartingFromRoot(head.next, root.left) 
				|| hasPathStartingFromRoot(head.next, root.right);
	}
}
