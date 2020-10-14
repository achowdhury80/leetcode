package comp.prep2019.less2000;
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
        		if (neighbour[0] < 0 || neighbour[0] >= grid.length || neighbour[1] < 0 || neighbour[1] >= grid[0].length) {
        			flag = true;
        			continue;
        		}
        		if (visited.contains(neighbour[0] + "," + neighbour[1])) continue;
        		if (grid[neighbour[0]][neighbour[1]] != oldColor) {
    				flag = true;
    				continue;
    			}
        		q.offer(neighbour);
        	}
        	if (flag) {
        		grid[coOrd[0]][coOrd[1]] = color;
        	}
        	
        }
        return grid;
    }
}
