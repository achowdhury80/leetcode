package comp.prep2019;
import java.util.*;
public class Prob1029 {
	/**
	 * O(NlogN)
	 * find gain for scheduling for first city by costs[i][0] - costs[i][1]
	 * order them by max gain. smaller value means more gain
	 * take first half for city 1 and next half for city 2
	 * @param costs
	 * @return
	 */
	public int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		Arrays.sort(costs, (x, y) -> x[0] - x[1] - y[0] + y[1]);
        int result = 0;
        for (int i = 0; i < n / 2; i++) result += costs[i][0];
        for (int i = n / 2; i < n; i++) result += costs[i][1];
        return result;
    }
}
