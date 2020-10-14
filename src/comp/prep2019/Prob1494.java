package comp.prep2019;
import java.util.*;
public class Prob1494 {
	public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
		int[] indeg = new int[n + 1];
		List<Integer>[] nexts = new List[n + 1];
        for (int[] dep : dependencies) {
        	indeg[dep[1]]++;
        	if (nexts[dep[0]] == null) nexts[dep[0]] = new ArrayList<>();
        	nexts[dep[0]].add(dep[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
        	if (indeg[i] == 0) q.offer(i);
        }
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result += (size / k) + (size % k == 0 ? 0 : 1); 
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		if (nexts[cur] != null) {
        			for (int next : nexts[cur]) {
        				indeg[next]--;
        				if (indeg[next] == 0) q.offer(next);
        			}
        		}
        	}
        }
        return result;
    }
}
