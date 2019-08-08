package com.leet.algo;
import java.util.*;
public class Prob1034 {
	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid[r0][c0] == color) return grid;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r0, c0});
        int oldColor = grid[r0][c0];
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()) {
        	int[] coOrd = q.poll();
        	visited.add(coOrd[0] + "," + coOrd[1]);
        	boolean flag = false; //to color or not
        	for (int[] dir : dirs) {
        		int[] neighbour = new int[] {coOrd[0] + dir[0], coOrd[1] + dir[1]};
        		if (neighbour[0] > -1 && neighbour[0] < grid.length && neighbour[1] > -1 && neighbour[1] < grid[0].length){ 
        			if (grid[neighbour[0]][neighbour[1]] != oldColor && grid[neighbour[0]][neighbour[1]] != color) {
        				flag = true;
        				continue;
        			}
        			if (visited.contains(neighbour[0] + "," + neighbour[1])) continue;
        			q.offer(neighbour);
        		}
        	}
        	if (flag || coOrd[0] == 0 || coOrd[0] == grid.length - 1 || coOrd[1] == 0 || coOrd[1] == grid[0].length - 1) {
        		grid[coOrd[0]][coOrd[1]] = color;
        	}
        	
        }
        return grid;
    }
	
	public static void main(String[] args) {
		Prob1034 prob = new Prob1034();
		int[][] grid = prob.colorBorder(new int[][] {{1,1},{1,2}}, 0, 0, 3);
		System.out.println(grid);
	}
}
