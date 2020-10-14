package comp.prep2019.less1000;
import java.util.*;
public class Prob815 {
	public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> stationToBusMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
        	for (int station : routes[i]) {
        		List<Integer> list 
        			= stationToBusMap.getOrDefault(station, new ArrayList<>());
        		list.add(i);
        		stationToBusMap.put(station, list);
        	}
        }
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> usedBus = new HashSet<>();
        q.offer(S);
        visited.add(S);
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		if (!stationToBusMap.containsKey(cur)) continue;
        		for (int bus : stationToBusMap.get(cur)) {
        			if (usedBus.contains(bus)) continue;
        			usedBus.add(bus);
        			for (int station : routes[bus]) {
        				if (station == T) return result;
        				if (visited.contains(station)) continue;
        				visited.add(station);
        				q.offer(station);
        			}
        		}
        	}
        }
        return -1;
    }
}
