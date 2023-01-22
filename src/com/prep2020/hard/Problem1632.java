package com.prep2020.hard;
import java.util.*;
public class Problem1632 {
	public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indeg = new int[m][n];
        List<int[]>[][] nexts = new List[m][n];
        for(int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		nexts[i][j] = new ArrayList<>();
        	}
        }
        for (int i = 0; i < m; i++) {
        	List<int[]> list = new ArrayList<>();
        	for (int j = 0; j < n; j++) list.add(new int[] {i, j});
        	setDependency(matrix, indeg, nexts, list);
        }
        for (int i = 0; i < n; i++) {
        	List<int[]> list = new ArrayList<>();
        	for (int j = 0; j < m; j++) list.add(new int[] {j, i});
        	setDependency(matrix, indeg, nexts, list);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if(indeg[i][j] == 0) q.offer(new int[] {i, j});
        	}
        }
        int rank = 0;
        int[][] result = new int[m][n];
        while (!q.isEmpty()) {
        	rank++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		result[cur[0]][cur[1]] = rank;
        		for (int[] next : nexts[cur[0]][cur[1]]) {
        			indeg[next[0]][next[1]]--;
        			if (indeg[next[0]][next[1]] == 0) q.offer(next);
        		}
        	}
        }
        return result;
    }
	
	private void setDependency(int[][] matrix, int[][] indeg, List<int[]>[][] nexts, List<int[]> list) {
		Collections.sort(list, (x, y) -> matrix[x[0]][x[1]] - matrix[y[0]][y[1]]);
		int i = 0, j = -1;
		for (int k = i + 1; k < list.size(); k++) {
			int[] curIdx = list.get(k), prevIdx = list.get(k - 1);
			if (matrix[curIdx[0]][curIdx[1]] > matrix[prevIdx[0]][prevIdx[1]]) {
				if (j == -1) j = k;
				else {
					for (int x = i ; x < j; x++) {
						int[] xIdx = list.get(x);
						for (int y = j; y < k; y++) {
							int[] yIdx = list.get(y);
							indeg[yIdx[0]][yIdx[1]]++;
							nexts[xIdx[0]][xIdx[1]].add(yIdx);
						}
					}
					i = j;
					j = k;
				}
			} 
		}
		if (j != -1) {
			for (int x = i ; x < j; x++) {
				int[] xIdx = list.get(x);
				for (int y = j; y < list.size(); y++) {
					int[] yIdx = list.get(y);
					indeg[yIdx[0]][yIdx[1]]++;
					nexts[xIdx[0]][xIdx[1]].add(yIdx);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Problem1632 problem = new Problem1632();
		int[][] result = problem.matrixRankTransform(new int[][]{{-37,-50,-3,44},{-37,46,13,-32},{47,-42,-3,-40},
			{-17,-22,-39,24}});
		System.out.println(result);
	}
}
