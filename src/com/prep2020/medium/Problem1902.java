package com.prep2020.medium;
import java.util.*;
public class Problem1902 {
	public int maxDepthBST(int[] order) {
        
        // brute force o(n^2) with insert each node
        // using treeset to get the lower and higher, o(nlogn)
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < order.length; i++) {
            Map.Entry<Integer,Integer> lower = map.lowerEntry(order[i]);
            Map.Entry<Integer,Integer> higher = map.higherEntry(order[i]);
            
            int depth = 1;
            if (lower != null) {
                depth = Math.max(1, lower.getValue() + 1);
            }
            
            if (higher != null) {
                depth = Math.max(depth, higher.getValue() + 1);
            }
            map.put(order[i], depth);
        }
        
        int max = 0;
        for (int depth : map.values()) {
            max = Math.max(max, depth);
        }
        return max;
    }

	class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}
}
