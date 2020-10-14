package comp.prep2019.less1000;
import java.util.*;
public class Prob444 {
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
	    Map<Integer, Set<Integer>> graph = new HashMap<>();
	    Map<Integer, Integer> inDegree = new HashMap<>();
	    for (List<Integer> seq : seqs) {
	      if (seq.size() == 1) {
	        if (!graph.containsKey(seq.get(0))) {
	          graph.put(seq.get(0), new HashSet<>());
	          inDegree.put(seq.get(0), 0);
	        }
	      } else {
	        for (int j = 0; j < seq.size() - 1; j++) {
	          if (!graph.containsKey(seq.get(j))) {
	            graph.put(seq.get(j), new HashSet<>());
	            inDegree.put(seq.get(j), 0);
	          }
	          if (!graph.containsKey(seq.get(j + 1))){
	            graph.put(seq.get(j + 1), new HashSet<>());
	            inDegree.put(seq.get(j + 1), 0);
	          }
	          if (graph.get(seq.get(j)).add(seq.get(j + 1))){
	            inDegree.put(seq.get(j + 1), inDegree.get(seq.get(j + 1)) + 1);
	          }
	        }
	      }
	    }
	    Queue<Integer> q = new LinkedList<>();
	    for (Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
	      if (entry.getValue() == 0) q.offer(entry.getKey());
	    }
	    int index = 0;
	    while (!q.isEmpty()) {
	      if (q.size() > 1) return false;
	      int cur = q.poll();
	      if (index == org.length || org[index++] != cur) return false;
	      for (int next : graph.get(cur)) {
	        inDegree.put(next, inDegree.get(next) - 1);
	        if (inDegree.get(next) == 0) q.offer(next);
	      }
	    }
	    return index == org.length && index == graph.size();
	  }
}
