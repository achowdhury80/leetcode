package comp.prep2019;
import java.util.*;
public class Prob785 {
	public boolean isBipartite1(int[][] graph) {
        Set<Integer>[] sets = new Set[] {new HashSet<>(), new HashSet<>()};
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
	
	public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
        	if (color[i] != 0) continue;
        	q.offer(i);
        	color[i] = 1;
        	while(!q.isEmpty()) {
        		int node = q.poll();
        		for (int j : graph[node]) {
        			if (color[j] == color[node]) return false;
        			if (color[j] != 0) continue;
        			color[j] = 1 + (color[node] % 2);
        			q.offer(j);
        		}
        	}
        }
        return true;
    }
}
