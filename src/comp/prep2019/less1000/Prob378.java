package comp.prep2019.less1000;
import java.util.*;
public class Prob378 {
	public int kthSmallest(int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        if (k == 1) return matrix[0][0];
        Queue<int[]> q = new PriorityQueue<>((x, y) -> matrix[x[0]][x[1]] - matrix[y[0]][y[1]]);
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (k == 1) return matrix[cur[0]][cur[1]];
        	k--;
        	if (cur[1] + 1 < matrix[0].length && !visited[cur[0]][cur[1] + 1]) {
        		visited[cur[0]][cur[1] + 1] = true;
        		q.offer(new int[] {cur[0], cur[1] + 1});
        	}
        	if (cur[0] + 1 < matrix.length && !visited[cur[0] + 1][cur[1]]) {
        		visited[cur[0] + 1][cur[1]] = true;
        		q.offer(new int[] {cur[0] + 1, cur[1]});
        	}
        }
        return 0;
    }
}
