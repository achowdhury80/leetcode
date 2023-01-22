package com.prep2020.medium.more2000;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem2196 {
	public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Boolean> isRoot = new HashMap<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int[] desc : descriptions) {
        	TreeNode parent = nodeMap.getOrDefault(desc[0], new TreeNode(desc[0]));
        	nodeMap.put(desc[0], parent);
        	TreeNode child = nodeMap.getOrDefault(desc[1], new TreeNode(desc[1]));
        	nodeMap.put(desc[1], child);
        	isRoot.put(desc[1], false);
        	if (!isRoot.containsKey(desc[0])) isRoot.put(desc[0], true);
        	if (desc[2] == 1) parent.left = child;
        	else parent.right = child;
        }
        for (Map.Entry<Integer, Boolean> entry : isRoot.entrySet()) {
        	if (entry.getValue()) return nodeMap.get(entry.getKey());
        }
        return null;
    }
}
