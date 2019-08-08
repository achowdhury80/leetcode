package com.leet.algo;
import java.util.*;
public class Prob1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] cells = new boolean[R][C];
        int[][] result = new int[R * C][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r0, c0});
        int idx = 0;
        while(!q.isEmpty()) {
        	int[] cell = q.poll();
        	if (!cells[cell[0]][cell[1]]) {
        		result[idx++] = cell;
        		cells[cell[0]][cell[1]] = true;
        		
        		for (int[] c : findNeighbors(cells, cell, R, C)) {
            		q.offer(c);
            	}
    		} 
        }
        return result;
    }
	
	private List<int[]> findNeighbors(boolean[][] cells, int[] cur, int R, int C){
		List<int[]> result = new ArrayList<>();
		if (cur[0] + 1 < R && !cells[cur[0] + 1][cur[1]]) result.add(new int[] {cur[0] + 1, cur[1]});
		if (cur[0] - 1 > -1 && !cells[cur[0] - 1][cur[1]]) result.add(new int[] {cur[0] - 1, cur[1]});
		if (cur[1] + 1 < C && !cells[cur[0]][cur[1] + 1]) result.add(new int[] {cur[0], cur[1] + 1});
		if (cur[1] - 1 > -1 && !cells[cur[0]][cur[1] - 1]) result.add(new int[] {cur[0], cur[1] - 1});
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Prob1030 prob = new Prob1030();
		int[][] result = prob.allCellsDistOrder(2, 2, 0, 1);
		System.out.println(result);
	}
}
