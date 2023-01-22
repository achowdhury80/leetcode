package com.prep2020.hard;
import java.util.*;
public class Problem296 {
	/**
	 * O(MN) time and O(M + N) space
	 * Get X and Y co-ordinate
	 * Sort them
	 * find the distances
	 * @param grid
	 * @return
	 */
	public int minTotalDistance(int[][] grid) {
        int m, n;
        if ((m = grid.length) == 0 || (n = grid[0].length) == 0) return 0;
        List<Integer> xList = new ArrayList<>(), yList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			xList.add(i);
        			yList.add(j);
        		}
        	}
        }
        return findMinDistance(xList) + findMinDistance(yList);
    }

	private int findMinDistance(List<Integer> list) {
		Collections.sort(list);
		int i = 0, j = list.size() - 1;
		int result = 0;
		while(i < j) result += list.get(j--) - list.get(i++);
		return result;
	}
}
