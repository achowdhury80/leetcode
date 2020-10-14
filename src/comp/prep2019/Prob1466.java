package comp.prep2019;
import java.util.*;
public class Prob1466 {
	public int minReorder(int n, int[][] connections) {
        Set<Integer>[] incoming = new HashSet[n], outgoing = new HashSet[n];
        for (int i = 0; i < n; i++) {
        	incoming[i] = new HashSet<>();
        	outgoing[i] = new HashSet<>();
        }
        for (int[] con : connections) {
        	outgoing[con[0]].add(con[1]);
        	incoming[con[1]].add(con[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		for (int node : incoming[cur]) {
        			if (!visited[node]) {
        				q.offer(node);
        				visited[node] = true;
        			}
        		}
        		for (int node : outgoing[cur]) {
        			if (!visited[node]) {
        				q.offer(node);
        				visited[node] = true;
        				result++;
        			}
        		}
        	}
        }
        return result;
    }
}
