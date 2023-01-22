package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem536 {
	public TreeNode str2tree(String s) {
		if ("".equals(s)) return null;
        int[] index = findLeftNRightStart(s);
        if (index[0] == -1) {
        	return new TreeNode(Integer.valueOf(s));
        }
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0, index[0])));
        String leftString = s.substring(index[0] + 1, index[1] == -1 
        		? s.length() - 1 : index[1] - 1);
        root.left = str2tree(leftString);
        if (index[1] > -1) 
        	root.right = str2tree(s.substring(index[1] + 1, s.length() - 1));
        return root;
    }
	
	private int[] findLeftNRightStart(String s) {
		int[] result = new int[] {-1, -1};
		int leftStart = s.indexOf('(');
		if (leftStart < 0) return result;
		result[0] = leftStart;
		int count = 1, i = leftStart + 1;
		for (; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') count++;
			else if (c == ')') count--;
			if (count == 0) break;
		}
		i++;
		if (i == s.length()) return result;
		result[1] = i;
		return result;
	}
}
