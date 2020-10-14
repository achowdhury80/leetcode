package comp.prep2019.less2000;
import java.util.*;
public class Prob1311 {
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, 
			int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        int k = 0;
        while(!q.isEmpty() && k < level) {
        	k++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		for (int f : friends[cur]) {
        			if (visited.contains(f)) continue;
        			visited.add(f);
        			q.offer(f);
        		}
        	}
        }
        Map<String, Integer> map = new HashMap<>();
        if (k == level && !q.isEmpty()) {
        	while(!q.isEmpty()) {
        		int cur = q.poll();
        		for (String v : watchedVideos.get(cur)) {
        			map.put(v, map.getOrDefault(v, 0) + 1);
        		}
        	}
        	List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    		Collections.sort(list, (x, y) -> (x.getValue() == y.getValue()) 
    				? x.getKey().compareTo(y.getKey()) : (x.getValue() - y.getValue()));
    		List<String> result = new ArrayList<>();
    		for (Map.Entry<String, Integer> entry : list) {
    			result.add(entry.getKey());
    		}
    		return result;
    	}
        return new ArrayList<>();
    }
	
	public static void main(String[] args) {
		Prob1311 prob = new Prob1311();
		
	}
}
