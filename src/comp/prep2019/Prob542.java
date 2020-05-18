package comp.prep2019;
import java.util.*;
public class Prob542 {
	public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 0) {
        			for (int[] dir : dirs) {
    					int[] next = new int[] {i + dir[0], j + dir[1]};
    					if (next[0] > - 1 && next[0] < m && next[1] > - 1 
    							&& next[1] < n && matrix[next[0]][next[1]] == 1) {
    						q.offer(next);
    						matrix[next[0]][next[1]] = -1;
    					}
    				}
        		}
        	}
        }
        int result = 1;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
					if (next[0] > - 1 && next[0] < m && next[1] > - 1 
							&& next[1] < n && matrix[next[0]][next[1]] == 1) {
						q.offer(next);
						matrix[next[0]][next[1]] = -result ;
					}
				}
        	}
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] < 0) {
        			matrix[i][j] *= -1;
        		}
        	}
        }
        return matrix;
    }
}
