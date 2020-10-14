package comp.prep2019;
import java.util.*;
public class Prob731 {
	private Map<Integer, Integer> treeMap = new TreeMap<>();
	public Prob731() {
        this.treeMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        int active = 0;
        for (int val : treeMap.values()) {
        	active += val;
        	if (active >= 3) {
        		treeMap.put(start, treeMap.get(start) - 1);
                treeMap.put(end, treeMap.get(end) + 1);
                if (treeMap.get(start) == 0) treeMap.remove(start);
                if (treeMap.get(end) == 0) treeMap.remove(end);
                return false;
        	}
        }
        return true;
    }
}
