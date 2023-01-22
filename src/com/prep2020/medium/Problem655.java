package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem655 {
	public List<List<String>> printTree(TreeNode root) {
        int height = findHeight(root);
        int width = (int)Math.pow(2, height) - 1;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < width; i++) list.add("");
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) result.add(new ArrayList<>(list));
        print(result, root, 0, 0, width - 1);
        return result;
    }
	
	private int findHeight(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(findHeight(root.left), findHeight(root.right));
	}
	
	private void print(List<List<String>> result, TreeNode root, int row, int leftLimit, int rightLimit) {
		if (root == null) return;
		int pos = (leftLimit + rightLimit) / 2;
		result.get(row).set(pos, "" + root.val);
		print(result, root.left, row + 1, leftLimit, pos - 1);
		print(result, root.right, row + 1, pos + 1, rightLimit);
	}
}
