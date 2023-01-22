package com.prep2020.medium;

public class Problem547 {
	/**
	 * Time complexity : O(n^3)
 ). We traverse over the complete matrix once. Union and find operations take O(n) time in the worst case.
Space complexity : O(n). parentparent array of size nn is used.
	 * @param isConnected
	 * @return
	 */
	public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int islands = n;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == j || isConnected[i][j] == 0) continue;
        		int p1 = findParent(parents, i), p2 = findParent(parents, j);
        		if (p1 != p2) {
        			islands--;
        			if (p1 < p2) parents[p2] = p1;
        			else parents[p1] = p2;
        		}
        	}
        }
        return islands;
    }
	
	private int findParent(int[] parents, int i) {
		while(parents[i] != i) i = parents[i];
		return i;
	}
}
