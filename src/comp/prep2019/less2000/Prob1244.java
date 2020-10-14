package comp.prep2019.less2000;
import java.util.*;
public class Prob1244 {
	private Map<Integer, Integer> map;
	public Prob1244() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        Queue<Integer> q = new PriorityQueue<>();
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	q.offer(entry.getValue());
        	result += entry.getValue();
        	if (q.size() > K) {
        		int val = q.poll();
        		result -= val;
        	}
        }
        return result;
    }
    
    public void reset(int playerId) {
        map.remove(playerId);
    }
}
