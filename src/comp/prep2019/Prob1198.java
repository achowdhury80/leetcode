package comp.prep2019;
import java.util.*;
public class Prob1198 {
	public int smallestCommonElement(int[][] mat) {
		int m = mat.length, n = mat[0].length;
        int max = 0;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> mat[x[0]][x[1]] - mat[y[0]][y[1]]);
        for (int i = 0; i < m; i++) {
        	int val = mat[i][0];
        	if (val > max) max = val;
        	q.offer(new int[] {i,0});
        }
        while(true) {
        	int[] peekIdx = q.peek();
        	if (max == mat[peekIdx[0]][peekIdx[1]]) return max;
        	int[] cur = q.poll();
        	cur[1]++;
        	if (cur[1] == n) return -1;
        	int val = mat[cur[0]][cur[1]];
        	if (val > max) max = val;
        	q.offer(cur);
        }
    }
}
