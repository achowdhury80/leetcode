package com.prep2020.medium;

public class Problem427 {
	public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid, 0, 0, n);
    }
	
	private Node helper(int[][] grid, int i, int j, int len) {
		if (len == 1) return new Node(grid[i][j] == 1, true);
		Node topLeft = helper(grid, i, j, len / 2);
		Node topRight = helper(grid, i, j + len / 2, len / 2);
		Node bottomLeft = helper(grid, i + len / 2, j, len / 2);
		Node bottomRight = helper(grid, i + len / 2, j + len / 2, len / 2);
		if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf 
				&& bottomRight.isLeaf && topLeft.val == topRight.val 
				&& topRight.val == bottomLeft.val 
				&& bottomLeft.val == bottomRight.val)
			return new Node(topLeft.val, true);
		return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
	}
	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    
	    public Node() {
	        this.val = false;
	        this.isLeaf = false;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = topLeft;
	        this.topRight = topRight;
	        this.bottomLeft = bottomLeft;
	        this.bottomRight = bottomRight;
	    }
	}

}
