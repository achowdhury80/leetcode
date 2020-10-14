package comp.prep2019.less1000;
import java.util.*;
public class Prob380 {
	private Map<Integer, Integer> map;
	private List<Integer> list;
	private Random random;
	/** Initialize your data structure here. */
    public Prob380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int lastVal = list.get(list.size() - 1); 
        if (lastVal != val) {
        	int valIdx = map.get(val);
        	list.set(valIdx, lastVal);
        	map.put(lastVal, valIdx);
        	
        }
        list.remove(list.size() - 1);
    	map.remove(val);
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
