package comp.prep2019;
import java.util.*;
public class Prob797 {
	/**
	 * O(pow(2, N)*N) time and space
	 * @param graph
	 * @return
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		 Map<Integer, List<List<Integer>>> map = new HashMap<>();
		 return pathToEnd(graph, 0, map);
    }
	
	private List<List<Integer>> pathToEnd(int[][] graph, int source, Map<Integer, List<List<Integer>>> map) {
		if (map.containsKey(source)) return map.get(source);
		List<List<Integer>> paths = new ArrayList<>();
		for (int next : graph[source]) {
			if (next == graph.length - 1) {
				List<Integer> list = new ArrayList<>();
				list.add(next);
				list.add(0, source);
				paths.add(list);
			} else {
				List<List<Integer>> subs = pathToEnd(graph, next, map);
				if (subs != null) {
					List<List<Integer>> temp = new ArrayList<>();
					for (List<Integer> l : subs) {
						List<Integer> newL = new ArrayList<>(l);
						newL.add(0, source);
						temp.add(newL);
					}
					paths.addAll(temp);
				}
			}
		}
		if (paths.isEmpty()) return null;
		map.put(source, paths);
		return paths;
	}
}
