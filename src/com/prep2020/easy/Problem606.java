package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem606 {
	/**
	 * O(N) time and O(H) space
	 * @param t
	 * @return
	 */
	public String tree2str(TreeNode t) {
        String result = "";
        if (t == null) return result;
        result += t.val;
        if (t.left != null) result += "(" + tree2str(t.left) + ")";
        else if (t.right != null) result += "()";
        if (t.right != null) result += "(" + tree2str(t.right) + ")";
        return result;
    }
}
