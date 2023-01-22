package com.prep2020.hard;
import java.util.*;
public class Problem1168 {
	/**
	 * O(m + n)log(m + n)
	 * O(m + n) space
	 * @param n
	 * @param wells
	 * @param pipes
	 * @return
	 */
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        // min heap to maintain the order of edges to be visited.
        Queue<int[]> edgesHeap = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
        for (int i = 1; i <= n; i++) {
        	graph.get(0).add(new int[] {i, wells[i - 1]});
        	edgesHeap.offer(new int[] {i, wells[i - 1]});
        }
        for (int[] pipe : pipes) {
        	graph.get(pipe[0]).add(new int[] {pipe[1], pipe[2]});
        	graph.get(pipe[1]).add(new int[] {pipe[0], pipe[2]});
        }
        
        Set<Integer> mstSet = new HashSet<>();
        mstSet.add(0);
        int result = 0;
        while(mstSet.size() < n + 1) {
        	int[] arr = edgesHeap.poll();
        	if (mstSet.contains(arr[0])) continue;
        	mstSet.add(arr[0]);
        	result += arr[1];
        	for (int[] neighboor : graph.get(arr[0])) {
        		if (!mstSet.contains(neighboor[0])) edgesHeap.offer(new int[] {neighboor[0], neighboor[1]});
        	}
        }
        return result;
    }
}
