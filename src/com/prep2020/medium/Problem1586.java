package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1586 {
	private List<Integer> list;
	private int cur = -1;
	public Problem1586(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root, list);
    }
	
	private void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}
    
    public boolean hasNext() {
        return cur < list.size() - 1;
    }
    
    public int next() {
        cur++;
        return list.get(cur);
    }
    
    public boolean hasPrev() {
    	return cur > 0;
    }
    
    public int prev() {
    	cur--;
    	return list.get(cur);
    }
}
