package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem623 {
	/**
	 * O(N) time and space
	 * @param root
	 * @param val
	 * @param depth
	 * @return
	 */
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
        	TreeNode node = new TreeNode(val);
        	node.left = root;
        	return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int level = 2;
        while(level < depth) {
        	List<TreeNode> temp = new ArrayList<>();
        	for (TreeNode node : list) {
        		if (node.left != null) temp.add(node.left);
        		if (node.right != null) temp.add(node.right);
        	}
        	level++;
        	list = temp;
        }
        for(TreeNode node : list) {
        	TreeNode newNode = new TreeNode(val);
        	newNode.left = node.left;
        	node.left = newNode;
        	newNode = new TreeNode(val);
        	newNode.right = node.right;
        	node.right = newNode;
        }
        return root;
    }
}
