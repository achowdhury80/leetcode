package comp.prep2019;

import java.util.HashMap;
import java.util.Map;

public class Prob170 {
	 private Map<Integer, Integer> map;
	  /** Initialize your data structure here. */
	  public Prob170() {
	    map = new HashMap<>();
	  }

	  /** Add the number to an internal data structure.. */
	  public void add(int number) {
	    map.put(number, map.getOrDefault(number, 0) + 1 > 1 ? 2 : 1);
	  }

	  /** Find if there exists any pair of numbers which sum is equal to the value. */
	  public boolean find(int value) {
	    for (int key : map.keySet()) {
	      if (map.containsKey(value - key)) {
	        if (key != value - key || map.get(key) == 2) return true;
	      }
	    }
	    return false;
	  }
}
