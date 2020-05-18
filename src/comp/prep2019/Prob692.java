package comp.prep2019;
import java.util.*;
public class Prob692 {
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
        	map.put(w, map.getOrDefault(w, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>((x, y) -> x.getValue() == y.getValue() 
        		? y.getKey().compareTo(x.getKey()) : x.getValue() - y.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	q.offer(entry);
        	if (q.size() > k) q.poll();
        }
        List<String> result = new ArrayList<>();
        while(!q.isEmpty()) {
        	result.add(0, q.poll().getKey());
        }
        return result;
    }
}
