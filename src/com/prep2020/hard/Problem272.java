package com.prep2020.hard;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem272 {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) return new ArrayList<>();
        List<Integer> left = closestKValues(root.left, target, k);
        List<Integer> right = closestKValues(root.right, target, k);
        if (left.size() < k || Math.abs(left.get(0) - target) > Math.abs(root.val - target)) {
        	if (left.size() == k) left.remove(0);
        	left.add(root.val);
        } else return left;
        left.addAll(right);
        while(left.size() > k) {
        	if(Math.abs(target - left.get(0)) > Math.abs(left.get(left.size() - 1) - target)) {
        		left.remove(0);
        	} else left.remove(left.size() - 1);
        }
        return left;
    }
}
