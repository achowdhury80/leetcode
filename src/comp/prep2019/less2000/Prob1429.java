package comp.prep2019.less2000;
import java.util.*;
public class Prob1429 {
	
	private Map<Integer, Boolean> map; // is not unique
	private Queue<Integer> q;
	
	public Prob1429(int[] nums) {
		q = new LinkedList<>();
        map = new HashMap<>();
        for (int num : nums) {
        	add(num);
        }
    }
    
    public int showFirstUnique() {
        while(!q.isEmpty()) {
        	int cur = q.peek();
        	if (!map.get(cur)) return cur;
        	q.poll();
        }
        return -1;
    }
    
    public void add(int value) {
        if (map.containsKey(value)) map.put(value, true);
        else {
        	map.put(value, false);
        	q.offer(value);
        }
    }
}
