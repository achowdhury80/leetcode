package comp.prep2019;
import java.util.*;
public class Prob1245 {
	/**
	 * O(N)
	 * @param edges
	 * @return
	 */
	public int treeDiameter(int[][] edges) {
		if (edges.length == 0) return 0;
        boolean[] visited = new boolean[edges.length + 1];
        Map<Integer, List<Integer>> map =  new HashMap<>();
        for (int[] edge : edges) {
        	List<Integer> vertices1 = map.getOrDefault(edge[0], new ArrayList<>());
        	List<Integer> vertices2 = map.getOrDefault(edge[1], new ArrayList<>());
        	vertices1.add(edge[1]);
        	vertices2.add(edge[0]);
        	map.put(edge[0], vertices1);
        	map.put(edge[1], vertices2);
        }
        int[] diameter = new int[1];
        findMaxDepth(0, map, diameter, visited);
        return diameter[0];
    }
	
	private int findMaxDepth(int vertex, Map<Integer, List<Integer>> map, 
			int[] diameter, boolean[] visited) {
		visited[vertex] = true;
		Queue<Integer> q = new PriorityQueue<>();
		for (int node : map.get(vertex)) {
			if (visited[node]) continue;
			int pathLen = findMaxDepth(node, map, diameter, visited);
			if (q.size() == 2 && q.peek() < pathLen) {
				q.poll();
				q.offer(pathLen);
			} else if (q.size() < 2) q.offer(pathLen);
		}
		if (q.size() == 0) return 0;
		int result = 0;
		if (q.size() == 1) {
			result = 1 + q.poll();
			diameter[0] = Math.max(diameter[0], result);
			return result;
		}
		result += q.poll();
		int max = q.poll();
		diameter[0] = Math.max(diameter[0], result + max + 2);
		return 1 + max;
	}
	
	public static void main(String[] args) {
		Prob1245 prob = new Prob1245();
		System.out.println(prob.treeDiameter(new int[][]{{0, 1},{0, 2}}));
	}
}
