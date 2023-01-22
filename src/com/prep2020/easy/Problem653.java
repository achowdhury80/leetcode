package com.prep2020.easy;

import java.util.HashSet;
import java.util.Set;

import com.prep2020.TreeNode;

public class Problem653 {
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
