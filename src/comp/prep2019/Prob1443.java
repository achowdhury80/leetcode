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
    	return helper(0, map, new boolean[n], hasApple)[1];
    }
	
	/**
	 * 0th element signifies(apple - 1, no apple - 0}, 1st element total walk 
	 * starting from the node
	 * @param root
	 * @param map
	 * @param visited
	 * @return
	 */
	private int[] helper(int root, Map<Integer, List<Integer>> map, 
			boolean[] visited, List<Boolean> hasApple) {
		visited[root] = true;
		int[] result = new int[2];
		for (int node : map.getOrDefault(root, new ArrayList<>())) {
			if (visited[node]) continue;
			int[] temp = helper(node, map, visited, hasApple);
			if (temp[0] == 0) continue;
			result[0] = 1;
			result[1] += temp[1] + 2;
		}
		if (result[0] == 0 && hasApple.get(root)) result[0] = 1;
		return result;
	}
}
