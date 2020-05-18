package comp.prep2019;
import java.util.*;
public class Prob1376 {
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	if (manager[i] > -1) {
        		List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
        		list.add(i);
        		map.put(manager[i], list);
        	}
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {headID, 0});
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (map.containsKey(cur[0])) {
        		for (int sub : map.get(cur[0])) {
        			int time = cur[1] + informTime[cur[0]];
        			q.offer(new int[] {sub, time});
        			result = Math.max(result, time);
        		}
        	}
        }
        return result;
    }
}
