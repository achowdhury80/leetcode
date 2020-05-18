package comp.prep2019;
import java.util.*;
public class Prob785 {
	public boolean isBipartite(int[][] graph) {
        Set<Integer>[] sets = new Set[] {new HashSet<>(), new HashSet<>()};
        boolean[] visited = new boolean[graph.length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
        	if (sets[0].contains(i) || sets[1].contains(i)) continue;
        	sets[0].add(i);
        	q.offer(new int[] {i, 0});
        	while(!q.isEmpty()) {
        		int[] arr = q.poll();
        		for (int j : graph[arr[0]]) {
        			if (sets[arr[1]].contains(j)) return false;
        			int setIdx = (arr[1] + 1) % 2;
        			if (!sets[setIdx].contains(j)) {
        				q.offer(new int[] {j, setIdx});
        				sets[setIdx].add(j);
        			}
        		}
        	}
        }
        return true;
    }
}
