package comp.prep2019.less1000;
import java.util.*;
public class Prob847 {
	/**
	 * load all nodes to queue
	 * maintain a status state which shows which are the nodes connected
	 * @param graph
	 * @return
	 */
	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		int mask = (1 << n) - 1;
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][1 << n];
		for (int i = 0; i < n; i++) {
			int state = (i << n) | (1 << i);
			q.offer(state);
			visited[i][1 << i] = true;
		}
		int result = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int state = q.poll();
				int status = state & mask;
				if (status == mask) return result;
				int node = (state >> n);
				for (int next : graph[node]) {
					int newStatus = status | (1 << next);
					int newState = (next << n) | newStatus;
					if (!visited[next][newStatus]) {
						visited[next][newStatus] = true;
						q.offer(newState);
					}
				}
			}
			result++;
		}
		return result;
    }
}
