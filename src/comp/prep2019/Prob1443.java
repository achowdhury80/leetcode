package comp.prep2019;
import java.util.*;
public class Prob1443 {
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
        	List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
        	list.add(edge[1]);
        	map.put(edge[0], list);
        	list = map.getOrDefault(edge[1], new ArrayList<>());
        	list.add(edge[0]);
        	map.put(edge[1], list);
        }
    	int[] result = new int[] {0};
    	boolean[] visited = new boolean[n];
    	visited[0] = true;
    	collectApple(0, hasApple, result, map, visited);
    	return result[0];
    }
	
	private boolean collectApple(int vertex, List<Boolean> hasApple, int[] time, 
			Map<Integer, List<Integer>> map, boolean[] visited) {
		boolean result = false;
		if (hasApple.get(vertex)) result = true;
		if (map.containsKey(vertex)) {
			for (int v : map.get(vertex)) {
				if (!visited[v]) {
					visited[v] = true;
					if (collectApple(v, hasApple, time, map, visited)) {
						time[0] += 2;
						result = true;
					}
				}
			}
		}
		return result;
	}
}
