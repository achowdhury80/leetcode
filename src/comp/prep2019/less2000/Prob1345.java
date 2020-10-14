package comp.prep2019.less2000;
import java.util.*;
public class Prob1345 {
	public int minJumps(int[] arr) {
		if (arr.length < 2) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
        	List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
        	list.add(i);
        	map.put(arr[i], list);
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(0);
        visited[0] = true;
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		if (cur - 1 > -1 && !visited[cur - 1]) {
        			visited[cur - 1] = true;
        			q.offer(cur - 1);
        		}
        		if (cur + 1 == arr.length - 1) return result;
        		if (cur + 1 < arr.length && !visited[cur + 1]) {
        			visited[cur + 1] = true;
        			q.offer(cur + 1);
        		}
        		if (map.containsKey(arr[cur])) {
	        		for (int idx : map.get(arr[cur])) {
	        			if (idx == cur) continue;
	        			if (idx == arr.length - 1) return result;
	        			if (!visited[idx]) {
	        				visited[idx] = true;
	        				q.offer(idx);
	        			}
	        		}
	        		map.remove(arr[cur]);
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1345 prob = new Prob1345();
		System.out.println(prob.minJumps(new int[] {100,-23,-23,404,100,23,23,23,3,404}));
	}
}
