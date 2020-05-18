package comp.prep2019;

public class Prob572 {
	/**
	 * Time complexity : O(m*n)O(m∗n). In worst case(skewed tree) traverse function takes O(m*n)O(m∗n) time.
		Space complexity : O(n)O(n). The depth of the recursion tree can go upto nn. nn refers to the number of nodes in ss.
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(isSameTree(s, t)) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	public boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == t) return true;
		if (s == null || t == null) return false;
		return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right); 
	}
}
