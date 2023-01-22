package com.prep2020.medium;

public class Problem1361 {
	/**
	 * indegree = 1 except root
	 * one root only
	 * no cycle
	 * @param n
	 * @param leftChild
	 * @param rightChild
	 * @return
	 */
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) {
        	if (leftChild[i] > -1) {
        		indeg[leftChild[i]]++;
        		if (indeg[leftChild[i]] > 1) return false;
        	}
        	
        	if (rightChild[i] > -1) {
        		indeg[rightChild[i]]++;
        		if (indeg[rightChild[i]] > 1) return false;
        	}
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
        	if (indeg[i] == 0) {
        		if (root != -1) return false;
        		root = i;
        	}
        }
        if (root == -1) return false;
        
        if (cycleExists(0, new int[n], leftChild, rightChild)) return false;
        return true;
    }
	
	private boolean cycleExists(int start, int[] color, int[] leftChild, 
			int[] rightChild) {
		if (color[start] == 1) return true;
		if (color[start] == 2) return false;
		color[start] = 1;
		if (leftChild[start] != -1 && cycleExists(leftChild[start], color, leftChild, 
				rightChild)) return true;
		if (rightChild[start] != -1 && cycleExists(rightChild[start], color, leftChild, 
				rightChild)) return true;
		color[start] = 2;
		return false;
	}
}
