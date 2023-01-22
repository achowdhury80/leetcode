package com.prep2020.hard;
import java.util.*;
public class Problem332 {
	public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Integer>> nexts = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
        	List<Integer> list = nexts.getOrDefault(tickets.get(i).get(0), 
        			new ArrayList<>());
        	list.add(i);
        	nexts.put(tickets.get(i).get(0), list);
        }
        
        for (List<Integer> list : nexts.values()) {
        	Collections.sort(list, (x, y) -> tickets.get(x).get(1)
        			.compareTo(tickets.get(y).get(1)));
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK", new boolean[tickets.size()], result, nexts, tickets);
        return result;
    }
	
	private boolean dfs(String cur, boolean[] used, List<String> path, 
			Map<String, List<Integer>> nexts, List<List<String>> tickets) {
		if (path.size() == used.length + 1) return true;
		if (!nexts.containsKey(cur)) return false;
		for (int ticket : nexts.get(cur)) {
			if (used[ticket]) continue;
			used[ticket] = true;
			path.add(tickets.get(ticket).get(1));
			if(dfs(tickets.get(ticket).get(1), used, path, nexts, tickets)) 
				return true;
			path.remove(path.size() - 1);
			used[ticket] = false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Problem332 problem = new Problem332();
		System.out.println(problem.findItinerary(Arrays.asList(
				Arrays.asList("MUC","LHR"),
				Arrays.asList("JFK","MUC"),
				Arrays.asList("SFO","SJC"),
				Arrays.asList("LHR","SFO"))));
	}
}
