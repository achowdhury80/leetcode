package com.prep2020.hard;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem1932 {
	public TreeNode canMerge(List<TreeNode> trees) {
        if (trees.size() == 1) return trees.get(0);
        Map<Integer, TreeNode> rootValMap = new HashMap<>(), leafToRootMap = new HashMap<>();
        Map<TreeNode, int[]> treeBoundary = new HashMap<>();
        Map<TreeNode, int[]> leafMaxMin = new HashMap<>();
        for (TreeNode t : trees) {
        	rootValMap.put(t.val, t);
        	int rootMin = t.val, rootMax = t.val;
        	if (t.left != null) {
        		rootMin = t.left.val;
        		leafMaxMin.put(t.left, new int[] {Integer.MIN_VALUE, t.val - 1});
        		if (leafToRootMap.containsKey(t.left.val)) return null;
        		leafToRootMap.put(t.left.val, t);
        	}
        	if (t.right != null) {
        		rootMax = t.right.val;
        		leafMaxMin.put(t.right, new int[] {t.val + 1, Integer.MAX_VALUE});
        		if (leafToRootMap.containsKey(t.right.val)) return null;
        		leafToRootMap.put(t.right.val, t);
        	}
        	if (t.left == null && t.right == null) {
        		if (leafToRootMap.containsKey(t.val)) return null;
        		leafToRootMap.put(t.val, t);
        		leafMaxMin.put(t.right, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE});
        	}
        	treeBoundary.put(t, new int[] {rootMin, rootMax});
        }
        
        return null;
    }
}
