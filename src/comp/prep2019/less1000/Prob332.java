package comp.prep2019.less1000;
import java.util.*;


public class Prob332 {
	public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
        	List<String> ticket = tickets.get(i);
        	List<Integer> list = map.getOrDefault(ticket.get(0), new ArrayList<>());
        	list.add(i);
        	map.put(ticket.get(0), list);
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
        	Collections.sort(entry.getValue(), (x, y) -> tickets.get(x).get(1).compareTo(tickets.get(y).get(1)));
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        helper(map, tickets, new boolean[tickets.size()], "JFK", result);
        return result;
    }
	
	private boolean helper(Map<String, List<Integer>> map, List<List<String>> tickets, boolean[] used, String start, List<String> result) {
		if (result.size() == tickets.size()) {
			List<Integer> nextTicket = map.get(start);
			for (int ticket : nextTicket) {
				if (!used[ticket]) {
					result.add(tickets.get(ticket).get(1));
					return true;
				}
			}
		}
		List<Integer> nextTicket = map.get(start);
		if (nextTicket == null) return false;
		for (int ticket : nextTicket) {
			if (!used[ticket]) {
				used[ticket] = true;
				result.add(tickets.get(ticket).get(1));
				if (helper(map, tickets, used, tickets.get(ticket).get(1), result)) return true;
				result.remove(result.size() - 1);
				used[ticket] = false;
			}
		}
		return false;
	}
}
