package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem314 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
        int min = 0, max = 0;
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        levelMap.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		int level = levelMap.get(node);
        		List<Integer> list = map.getOrDefault(level, new ArrayList<>());
        		list.add(node.val);
        		map.put(level, list);
        		if (node.left != null) {
        			levelMap.put(node.left, level - 1);
        			min = Math.min(min, level - 1);
        			q.offer(node.left);
        		}
        		if (node.right != null) {
        			levelMap.put(node.right, level + 1);
        			max = Math.max(max, level + 1);
        			q.offer(node.right);
        		}
        	}
        }
        for (int i = min; i <= max; i++) {
        	if (map.containsKey(i)) result.add(map.get(i));
        }
        return result;
    }
}
