package comp.prep2019;
import java.util.*;
public class Prob802 {
	/**
	 * o(n) time and space
	 * find outdegree count of all node
	 * if outdegree count is 0 then they should be part of result
	 * maintain an indegree map, so that for a node we can quickly find all the nodes 
	 * which has directed edge to the node
	 * if a nodes outdegree is 0, put it in q
	 * poll element from q. add to result
	 * for all nodes that have directed edge to the node, reduce their outdegree 
	 * by 1.  if outdegree is 0, add to q. so on..
	 * @param graph
	 * @return
	 */
	public List<Integer> eventualSafeNodes1(int[][] graph) {
        int n = graph.length;
        Set<Integer>[] indegree = new Set[n];
        int[] outdegreeCount = new int[n];
        Queue<Integer> q = new LinkedList<>();
        boolean[] safe = new boolean[n];
        for (int i = 0; i < graph.length; i++) {
        	outdegreeCount[i] = graph[i].length;
        	if (outdegreeCount[i] == 0) q.offer(i);
        	for (int next : graph[i]) {
        		if (indegree[next] == null) indegree[next] = new HashSet<>();
        		indegree[next].add(i);
        	}
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	safe[cur] = true;
        	if (indegree[cur] != null) {
        		for (int node : indegree[cur]) {
        			outdegreeCount[node]--;
        			if (outdegreeCount[node] == 0) q.offer(node);
        		}
        	}
        }
        for (int i = 0; i < n; i++) if (safe[i]) result.add(i);
        return result;
    }
	
	public List<Integer> eventualSafeNodes(int[][] graph) {
		int[] arr = new int[graph.length];
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (!hasCycle(graph, i, arr)) result.add(i);
		}
		return result;
	}
	
	private boolean hasCycle(int[][] graph, int start, int[] arr) {
		if (arr[start] == 2) return false;
		if (arr[start] == 1) return true;
		arr[start] = 1;
		if (graph[start] != null) {
			for (int next : graph[start]) {
				if (hasCycle(graph, next, arr)) return true; 
			}
		}
		arr[start] = 2;
		return false;
	}
}
