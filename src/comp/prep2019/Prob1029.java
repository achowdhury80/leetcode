package comp.prep2019;
import java.util.*;
public class Prob1029 {
	/**
	 * O(NlogN) & O(N)
	 * find gain for scheduling for first city by costs[i][0] - costs[i][1]
	 * order them by max gain. smaller value means more gain
	 * take first half for city 1 and next half for city 2
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
        Queue<Integer> q = new PriorityQueue<>((x, y) -> costs[x][0] - costs[x][1] 
        		- costs[y][0] + costs[y][1]);
        for (int i = 0; i < n; i++) q.offer(i);
        int result = 0;
        int count = 0;
        while(!q.isEmpty()) {
        	if (count < n / 2) result += costs[q.poll()][0];
        	else result += costs[q.poll()][1];
        	count++;
        }
        return result;
    }
}
