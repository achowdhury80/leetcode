package comp.prep2019;
import java.util.*;
public class Prob1306 {
	public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	int idx;
        	if ((idx = cur + arr[cur]) < arr.length) {
        		if (arr[idx] == 0) return true;
        		if (!visited[idx]) {
        			visited[idx] = true;
        			q.offer(idx);
        		}
        	}
        	if ((idx = cur - arr[cur]) > -1) {
        		if (arr[idx] == 0) return true;
        		if (!visited[idx]) {
        			visited[idx] = true;
        			q.offer(idx);
        		}
        	}
        }
        return false;
    }
}
