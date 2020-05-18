package comp.prep2019;
import java.util.*;
public class Prob323 {
	public int countComponents(int n, int[][] edges) {
        boolean[] connected = new boolean[n];
        // create a map of vertex and list of next points
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
        	List<Integer> nextPoints =  map.getOrDefault(edge[0], new ArrayList<>());
        	nextPoints.add(edge[1]);
        	map.put(edge[0], nextPoints);
        	nextPoints =  map.getOrDefault(edge[1], new ArrayList<>());
        	nextPoints.add(edge[0]);
        	map.put(edge[1], nextPoints);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if(connected[i]) continue;
        	result++;
        	Queue<Integer> q = new LinkedList<>();
        	q.offer(i);
        	while(!q.isEmpty()) {
        		int vertex = q.poll();
        		connected[vertex] = true;
        		if(map.containsKey(vertex)) {
        			for (int next : map.get(vertex)) {
        				if (!connected[next]) q.offer(next);
        			}
        		}
        	}
        }
        return result;
    }	
}
