package com.prep2020.medium;

public class Problem789 {
	/**
	 * O(N)
	 * @param ghosts
	 * @param target
	 * @return
	 */
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] g : ghosts) if (fidDis(g, target) <= dis) return false;
        return true;
    }

	private int fidDis(int[] g, int[] target) {
		return Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]);
	}
}
