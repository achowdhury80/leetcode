package comp.prep2019.less1000;
import java.util.*;
public class Prob310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
	    if (n == 0) return result;
	    if (n == 1){
	      result.add(0);
	      return result;
	    }
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    Map<Integer, Integer> inDegree = new HashMap<>();
	    for (int i = 0; i < edges.length; i++) {
	      if (!map.containsKey(edges[i][0])) map.put(edges[i][0], new ArrayList<>());
	      inDegree.put(edges[i][0], inDegree.getOrDefault(edges[i][0], 0) + 1);
	      map.get(edges[i][0]).add(edges[i][1]);
	      if (!map.containsKey(edges[i][1])) map.put(edges[i][1], new ArrayList<>());
	      inDegree.put(edges[i][1], inDegree.getOrDefault(edges[i][1], 0) + 1);
	      map.get(edges[i][1]).add(edges[i][0]);
	    }
	    Queue<Integer> q = new LinkedList<>();
	    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
	      if (entry.getValue() == 1) q.offer(entry.getKey());
	    }
	    while(!q.isEmpty()) {
	    	if (map.size() < 3) {
	    		for (int key : map.keySet()) result.add(key);
	    		break;
	    	}
	    	int size = q.size();
	    	for (int i = 0; i < size; i++) {
	    		int node = q.poll();
	    		for (int next : map.get(node)) {
	    			if (inDegree.containsKey(next)) {
	    				int degree = inDegree.get(next) - 1;
	    	            inDegree.put(next, degree);
	    	            if (degree == 1) q.offer(next);
	    			}
	    		}
	    		map.remove(node);
	    		inDegree.remove(node);
	    	}
	    }
	    return result;
    }
}
