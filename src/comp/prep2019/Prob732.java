package comp.prep2019;
import java.util.*;
public class Prob732 {
	/**
	 * O(N^2) time and O(N) space
	 */
	private TreeMap<Integer, Integer> delta;
	public Prob732() {
        delta = new TreeMap<>();
    }
    
    public int book(int start, int end) {
    	delta.put(start, delta.getOrDefault(start, 0) + 1);
    	delta.put(end, delta.getOrDefault(end, 0) - 1);
        int result = 0, active = 0;
        for (int d : delta.values()) {
        	active += d;
        	result = Math.max(result, active);
        }
        return result;
    }	
}
