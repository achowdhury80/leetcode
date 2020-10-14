package comp.prep2019;
import java.util.*;
public class Prob787 {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		if(src == dst) return 0;
	    Map<Integer, List<int[]>> map = new HashMap<>();
	    for (int i = 0; i < flights.length; i++) {
	      if (!map.containsKey(flights[i][0])) map.put(flights[i][0], new ArrayList<>());
	      map.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
	    }
	    int[] price = new int[n];
	    price[src] = 0;for (int i = 0; i < n; i++) price[i] = Integer.MAX_VALUE;
	    price[src] = 0;
	    Queue<int[]> q = new LinkedList<>();
	    if (map.containsKey(src)) {
		    for (int[] next : map.get(src)) {
		    	q.offer(new int[] {next[0], next[1]});
		    }
	    }
	    while(!q.isEmpty() && K > -1) {
	    	K--;
	    	int size = q.size();
	    	for (int i = 0; i < size; i++) {
	    		int[] cur = q.poll();
	    		price[cur[0]] = Math.min(price[cur[0]], cur[1]);
	    		if(map.containsKey(cur[0])) {
	    			for (int[] next : map.get(cur[0])) {
	    		    	q.offer(new int[] {next[0], next[1] + cur[1]});
	    		    }
	    		}
	    	}
	    }
	    if (price[dst] == Integer.MAX_VALUE) return -1;
	    return price[dst];
    }
	
	public static void main(String[] args) {
		Prob787 prob = new Prob787();
		System.out.println(prob.findCheapestPrice(4,
				new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
	}
}
