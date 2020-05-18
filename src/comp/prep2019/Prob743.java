package comp.prep2019;
import java.util.*;
public class Prob743 {
	public int networkDelayTime(int[][] times, int N, int K) {
	    if (times == null || times.length < 1) return 0;
	    Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
	    for (int i = 0; i < times.length; i++) {
	      if (!path.containsKey(times[i][0])) path.put(times[i][0], new HashMap<>());
	      path.get(times[i][0]).put(times[i][1], times[i][2]);
	    }
	    Map<Integer, Integer> distanceMap = new HashMap<>();
	    distanceMap.put(K, 0);
	    PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[1] - y[1]);
	    heap.add(new int[]{K, 0});
	    while (!heap.isEmpty()) {
	      int[] current = heap.poll();
	      if (distanceMap.containsKey(current[0]) && distanceMap.get(current[0]) < current[1]) continue;
	      Map<Integer, Integer> next = path.get(current[0]);
	      if (next == null) continue;
	      for (Map.Entry<Integer, Integer> entry : next.entrySet()) {
	        if (distanceMap.containsKey(entry.getKey()) && distanceMap.get(entry.getKey()) <= entry.getValue() + current[1])
	          continue;
	        distanceMap.put(entry.getKey(), entry.getValue() + current[1]);
	        heap.offer(new int[]{entry.getKey(), entry.getValue() + current[1]});
	      }
	    }

	    int max = Integer.MIN_VALUE;
	    for (Integer key : distanceMap.keySet()) max = Math.max(max, distanceMap.get(key));
	    return distanceMap.size() < N ? -1 : max;

	  }
	
	public static void main(String[] args) {
		Prob743 prob = new Prob743();
		System.out.println(prob.networkDelayTime(new int[][] {{2,1,1}, {2,3,1},{3, 4, 1}}, 4, 2));
	}
}
