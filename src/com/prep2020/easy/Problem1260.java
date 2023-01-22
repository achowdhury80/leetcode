package com.prep2020.easy;
import java.util.*;
public class Problem1260 {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	result.add(new ArrayList<>());
        	for (int j = 0; j < n; j++) result.get(i).add(grid[i][j]);
        }
        for (int i = 0; i < k; i++) shift(result);
        return result;
    }
	
	private void shift(List<List<Integer>> result) {
		List<Integer> list = new ArrayList<>();
		int n = result.get(0).size();
		for (int i = 0; i < result.size(); i++) {
			list.add(result.get(i).remove(n - 1));
		}
		list.add(0, list.remove(list.size() - 1));
		for (int i = 0; i < result.size(); i++) {
			result.get(i).add(0, list.remove(0));
		}
	}
	
	
	public static void main(String[] args) {
		Problem1260 problem = new Problem1260();
		List<List<Integer>> result = problem.shiftGrid(
				new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
		System.out.println(result);
	}
}
