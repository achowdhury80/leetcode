package comp.prep2019;
import java.util.*;
public class Prob1341 {
	public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] == y[0] ? 
        		x[1] - y[1] : x[0] - y[0]);
        for (int i = 0; i < mat.length; i++) {
        	int civilCount = findCivilCount(mat[i]);
        	q.offer(new int[] {civilCount, i});
        	if (q.size() > k) q.poll();
        }
        int[] result = new int[k];
        int idx = k - 1;
        while(!q.isEmpty()) {
        	result[idx--] = q.poll()[1];
        }
        return result;
    }
	
	private int findCivilCount(int[] r) {
		int l = 0, h = r.length - 1;
		while(l < h) {
			int mid = l + (h - l) / 2;
			if (r[mid] == 1) l = mid + 1;
			else h = mid;
		}
		return r.length - l;
	}
}
