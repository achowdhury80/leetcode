package com.prep2020.hard;
import java.util.*;
public class Problem265 {
	/**
	 * O(mn) time and o(1) space
	 * start from 1st house, keep two min costs and color index
	 * now for each house, take a specific color cost and add min costs till previous house
	 * if the last house have the same color index, take second min
	 * @param costs
	 * @return
	 */
	public int minCostII(int[][] costs) {
		int m, n;
		if((m = costs.length) == 0 || (n = costs[0].length) == 0) return 0;
		// 1st element cost and 2nd element color index. the pq is a mx queue with max size 2
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (y[0] - x[0]));
        for (int i = 0; i < n; i++) {
        	pq.offer(new int[] {costs[0][i], i});
        	if (pq.size() > 2) pq.poll();
        }
        
        for (int i = 1; i < m; i++) {
        	int[] secondMin = pq.poll(), min = pq.poll();
        	for (int j = 0; j < n; j++) {
        		pq.offer(new int[] {costs[i][j] + (j == min[1] ? secondMin[0] : min[0]), j});
        		if (pq.size() > 2) pq.poll();
        	}
        }
        
        if (pq.size() > 1) pq.poll();
        return pq.poll()[0];
    }
}
