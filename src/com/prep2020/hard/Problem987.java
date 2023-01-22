package com.prep2020.hard;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem987 {
	/**
	 * O(N) time and O(N) space
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> nodeIndexMap = new HashMap<>();
        nodeIndexMap.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int minIndex = 0, maxIndex = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	Map<Integer, List<Integer>> temp = new HashMap<>();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
            	int colIndex = nodeIndexMap.get(node);
            	List<Integer> list = temp.getOrDefault(colIndex, new ArrayList<>());
            	list.add(node.val);
            	temp.put(colIndex, list);
            	if (node.left != null) {
            		nodeIndexMap.put(node.left, colIndex - 1);
            		minIndex = Math.min(minIndex, colIndex - 1);
            		q.offer(node.left);
            	}
            	if (node.right != null) {
            		nodeIndexMap.put(node.right, colIndex + 1);
            		maxIndex = Math.max(maxIndex, colIndex + 1);
            		q.offer(node.right);
            	}
        	}
        	for (Map.Entry<Integer, List<Integer>> entry : temp.entrySet()) {
        		Collections.sort(entry.getValue());
        		if (map.containsKey(entry.getKey())) map.get(entry.getKey()).addAll(entry.getValue());
        		else map.put(entry.getKey(), entry.getValue());
        	}
        	
        }
        
        List<List<Integer>> result = new ArrayList<>();
    	for (int i = minIndex; i <= maxIndex; i++) {
    		if (map.containsKey(i)) result.add(map.get(i));
    	}
    		
    	return result;
    }
}
