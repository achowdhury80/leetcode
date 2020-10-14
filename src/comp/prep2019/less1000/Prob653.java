package comp.prep2019.less1000;

import java.util.HashSet;
import java.util.Set;

import comp.prep2019.TreeNode;

public class Prob653 {
	/**
	 * O(N) time and space
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget(TreeNode root, int k) {
	    if(root == null || (root.left == null && root.right == null)) return false;
	    Set<Integer> neededSet = new HashSet<>();
	    return findTarget(root, k, neededSet);

	  }

	  public boolean findTarget(TreeNode root, int k, Set<Integer> neededSet){
	    if(root == null) return false;
	    if(neededSet.contains(root.val)) return true;
	    neededSet.add(k - root.val);
	    return findTarget(root.left, k, neededSet) || findTarget(root.right, k, neededSet);
	  }
}
