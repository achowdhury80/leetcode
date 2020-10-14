package comp.prep2019.less1000;
import java.util.*;
public class Prob924 {
	public int minMalwareSpread(int[][] graph, int[] initial) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
        	for (int j = 0; j < graph[i].length; j++) {
        		if (graph[i][j] == 1 && i != j) {
        			List<Integer> list = g.getOrDefault(i, new ArrayList<>());
        			list.add(j);
        			g.put(i, list);
        		}
        	}
        }
        boolean[] infected = new boolean[graph.length];
        Set<Integer> initSet = new HashSet<>();
        for (int i : initial) initSet.add(i);
        Queue<Integer> q;
        // 0th element for node and 1st element for savings
        int[] result = new int[] {Integer.MAX_VALUE, 0}; 
        for (int i : initial) {
        	if (infected[i]) continue;
        	q = new LinkedList<>();
        	q.offer(i);
        	infected[i] = true;
        	int[] curResult = new int[] {i, 1};
        	while(!q.isEmpty()) {
        		int cur = q.poll();
        		if (!g.containsKey(cur)) continue;
        		for (int node : g.get(cur)) {
	        		if (infected[node]) continue;
	        		if (initSet.contains(node)) {
	        			curResult[1] = 0;
	        			curResult[0] = Math.min(curResult[0], node);
	        		}
	        		infected[node] = true;
	        		if (curResult[1] != 0) curResult[1]++;
	        		q.offer(node); 
        		}
        	}
        	if (curResult[1] > result[1]) result = curResult;
        	else if (curResult[1] == result[1]) result[0] = Math.min(result[0], 
        			curResult[0]);
        }
        return result[0];
    }
}
