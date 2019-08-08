package com.leet.algo;
import java.util.*;
public class Prob1129 {
	/**
	 * O(mlogn)
	 * array of egemap for each node
	 * maintain the color of last used edge color
	 * do bfs considering start came with red 
	 * again do bfs considering start came with blue
	 * visited should consider color plus node
	 * @param n
	 * @param red_edges
	 * @param blue_edges
	 * @return
	 */
	public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		int[] result = new int[n];
		for (int i = 1; i < n; i++) {
        	result[i] = -1;
        }
		Map<Integer, List<int[]>>[] edgeMap = new Map[]{new HashMap<>(), new HashMap<>()};
        for (int[] edge : red_edges) {
        	List<int[]> edgeList = edgeMap[0].getOrDefault(edge[0], new ArrayList<>());
        	edgeList.add(new int[] {edge[1], 0});
        	edgeMap[0].put(edge[0], edgeList);
        }
        for (int[] edge : blue_edges) {
        	List<int[]> edgeList = edgeMap[1].getOrDefault(edge[0], new ArrayList<>());
        	edgeList.add(new int[] {edge[1], 1});
        	edgeMap[1].put(edge[0], edgeList);
        }
		bfs(n, 0, edgeMap, result);
		bfs(n, 1, edgeMap, result);
		return result;
    }
	
	// color is o - red or 1 - blue
	private void bfs(int n, int color, Map<Integer, List<int[]>>[] edgeMap, int[] result) {
		Queue<int[]> q = new LinkedList<>(); 
		q.offer(new int[] {0, color});
		int depth = 0;
		Set<String> visited = new HashSet<>();
		visited.add(color + ":0");
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] node = q.poll();
				if (result[node[0]] == -1) result[node[0]] = depth;
				else result[node[0]] = Math.min(result[node[0]], depth);
				int nextColor = (node[1] ^ 1);
				if (edgeMap[nextColor].containsKey(node[0])) {
					for (int[] next : edgeMap[nextColor].get(node[0])) {
						String key = next[1] + ":" + next[0];
						if (!visited.contains(key)) {
							visited.add(key);
							q.offer(next);
						}
					}
				}
			}
			depth++;
		}
	}
	
	public static void main(String[] args) {
		Prob1129 prob = new Prob1129();
		int[] result = prob.shortestAlternatingPaths(3, new int[][] {{0, 1},{1, 2}}, new int[0][0]);
		for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
	}
}
