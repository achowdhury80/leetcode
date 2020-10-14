package comp.prep2019;
import java.util.*;
public class Prob1337 {
	/**
	 * O(mlognk) time and o(1) space
	 * @param mat
	 * @param k
	 * @return
	 */
	public int[] kWeakestRows(int[][] mat, int k) {
		Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] == y[0] ? 
        		y[1] - x[1] : y[0] - x[0]);
		for (int i = 0; i < mat.length; i++) {
			int s = 0;
			for (int j = 0; j < mat[i].length && mat[i][j] == 1; j++) {
				s++;
			}
			q.offer(new int[] {s, i});
			if (q.size() > k) q.poll();
		}
		int[] result = new int[k];
        int idx = k - 1;
        while(!q.isEmpty()) {
        	result[idx--] = q.poll()[1];
        }
        return result;
		
	}
}
