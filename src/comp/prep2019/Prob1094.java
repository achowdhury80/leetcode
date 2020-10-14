package comp.prep2019;
import java.util.*;
public class Prob1094 {
	/**
	 * O(NlogN)
	 * @param trips
	 * @param capacity
	 * @return
	 */
	public boolean carPooling(int[][] trips, int capacity) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> (x[0] == y[0]) ? (y[1] - x[1]) : x[0] - y[0]);
        for (int[] trip : trips) {
        	q.offer(new int[] {trip[1], 0, trip[0]});
        	q.offer(new int[] {trip[2], 1, -trip[0]});
        }
        int sum = 0;
        while(!q.isEmpty()) {
        	int[] arr = q.poll();
            sum += arr[2];
            if (sum > capacity) return false;
        	
        }
        return true;
    }
}
