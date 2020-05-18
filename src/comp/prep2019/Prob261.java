package comp.prep2019;
import java.util.*;
public class Prob261 {
	public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
        	int[] e = edges[i];
        	List<Integer> l1 = map.getOrDefault(e[0], new ArrayList<>());
        	List<Integer> l2 = map.getOrDefault(e[1], new ArrayList<>());
        	l1.add(i);
        	l2.add(i);
        	map.put(e[0], l1);
        	map.put(e[1], l2);
        }
        boolean[] used = new boolean[edges.length];
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited.add(0);
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	List<Integer> list = map.get(cur);
        	if (list == null) break;
        	for (int e : list) {
        		if (used[e]) continue;
        		int[] edge = edges[e];
        		int next = cur == edge[0] ? edge[1] : edge[0];
        		if (visited.contains(next)) 
        			return false; 
        		used[e] = true;
        		visited.add(next);
        		q.offer(next);
        	}
        }
        return visited.size() == n;
    }
}
