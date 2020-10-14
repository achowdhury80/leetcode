package comp.prep2019;
import java.util.*;
public class Prob1192 {
	//tarjan
	/**
	 * https://leetcode.com/problems/critical-connections-in-a-network/discuss/382632/Java-implementation-of-Tarjan-Algorithm-with-explanation
	 * @param n
	 * @param connections
	 * @return
	 */
	public List<List<Integer>> criticalConnections(int n, 
			List<List<Integer>> connections) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer>[] edges = new List[n]; 
		for (int i = 0; i < edges.length; i++) edges[i] = new ArrayList<>();
        for (List<Integer> list : connections) {
        	edges[list.get(0)].add(list.get(1));
        	edges[list.get(1)].add(list.get(0));
        }
        int[] discover = new int[n];
        for (int i = 0; i < n; i++) discover[i] = -1;
        helper(0, edges, new int[] {0}, discover, new int[n], 0, result);
        return result;
    }
	
	private void helper(int cur, List<Integer>[] edges, int[] time, int[] discover, 
			int[] low, int parent, List<List<Integer>> result) {
		discover[cur] = time[0];
		low[cur] = time[0];
		time[0]++;
		for (Integer next : edges[cur]) {
			if (next == parent) continue;
			if (discover[next] == -1) {
				helper(next, edges, time, discover, low, cur, result);
				low[cur] = Math.min(low[cur], low[next]);
				if (low[next] > discover[cur]) result.add(Arrays.asList(cur, next));
			} else {
				low[cur] = Math.min(low[cur], discover[next]);
			}
		}
	}
}
