package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2033 {
	public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int rem = grid[0][0] % x;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] % x != rem) return -1;
        		int idx = Collections.binarySearch(list, grid[i][j]);
        		if (idx < 0) idx = -(idx + 1);
        		list.add(idx, grid[i][j]);
        	}
        }
        int medianIdx = list.size() / 2;
        int result = 0;
        for (int i = 0; i < list.size(); i++) result += Math.abs(list.get(medianIdx) - list.get(i)) / x;
        return result;
    }
}
